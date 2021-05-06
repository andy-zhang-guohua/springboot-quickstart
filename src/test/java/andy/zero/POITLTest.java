package andy.zero;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.*;
import com.deepoove.poi.data.style.TableStyle;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class POITLTest {

    @Test
    public void newWordFileFromTemplate() throws IOException {
        //设置的合并规则
        MergeCellRule.MergeCellRuleBuilder mergeCellRuleBuilder = MergeCellRule.builder();
        //设置表头
        RowRenderData header = Rows.of("姓名", "特长", "是否获奖").bgColor("F2F2F2").center()
                .textColor("7F7f7F").textFontFamily("Hei").textFontSize(9).create();
        //表体内容
        RowRenderData row = Rows.of("小红", "游泳", "否").center().create();
        RowRenderData row1 = Rows.of("小红", "钢琴", "八级").center().create();
        RowRenderData row2 = Rows.of("小红", "围棋", "否").center().create();
        RowRenderData row3 = Rows.of("小明", "游泳", "全国一等奖").center().create();
        RowRenderData row4 = Rows.of("小明", "击剑", "无").center().create();
        RowRenderData row5 = Rows.of("小梅", "围棋", "无").center().create();
        RowRenderData row6 = Rows.of("小梅", "跆拳道", "黑带").center().create();
        RowRenderData row7 = Rows.of("小梅", "长跑", "国家一级运动员").center().create();
        RowRenderData row8 = Rows.of("小梅", "举重", "无").center().create();
        RowRenderData row9 = Rows.of("小刚", "脸特长", "").center().create();

        //设置样式颜色尺寸等等
        TableStyle.BorderStyle borderStyle = new TableStyle.BorderStyle();
        borderStyle.setColor("A6A6A6");
        borderStyle.setSize(4);
        borderStyle.setType(XWPFTable.XWPFBorderType.SINGLE);
        TableRenderData tableRenderData = Tables.ofA4MediumWidth().addRow(header)
                .addRow(row).addRow(row1).addRow(row2).addRow(row3).addRow(row4)
                .addRow(row5).addRow(row6).addRow(row7).addRow(row8).addRow(row9)
                .border(borderStyle).center()
                .create();
        /**
         * 设置表格合并规则
         * 1.起始行 MergeCellRule.Grid.of(i, j) i: 行 j: 列
         * 2.结束行 MergeCellRule.Grid.of(i, j) i: 行 j: 列
         */
        mergeCellRuleBuilder.map(MergeCellRule.Grid.of(1, 0), MergeCellRule.Grid.of(3, 0));//小红合并
        mergeCellRuleBuilder.map(MergeCellRule.Grid.of(4, 0), MergeCellRule.Grid.of(5, 0));//小明合并
        mergeCellRuleBuilder.map(MergeCellRule.Grid.of(6, 0), MergeCellRule.Grid.of(9, 0));//小梅合并

        /**
         * MergeCellRule支持多合并规则,会以Map的形式存入可以看一下源码
         * !!! 一定要设置完规则后再调用 MergeCellRule的build方法进行构建
         */
        tableRenderData.setMergeRule(mergeCellRuleBuilder.build());

        DocData docData = new DocData();
        docData.setTitle("代理销售合同");
        docData.setNameA("张家口鸡鸣山软件股份有限公司");
        docData.setNameB("张家口鸡鸣山软件测试有限公司");
        docData.setItems(tableRenderData);
        docData.setSignDateA(DateUtil.formatAsDatetime(new Date()));
        docData.setSignDateB(DateUtil.formatAsDatetime(new Date()));
        docData.setItems(tableRenderData);

        //核心API采用了极简设计，只需要一行代码
        File file = ResourceUtils.getFile("\\idea_wks\\springboot-quickstart\\src\\test\\resources\\template.docx");
        XWPFTemplate.compile(file).render(docData).writeToFile("contract.docx");
    }
}
