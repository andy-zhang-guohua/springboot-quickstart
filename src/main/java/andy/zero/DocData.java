package andy.zero;

import com.deepoove.poi.data.TableRenderData;
import lombok.Data;

@Data
public class DocData {
    String title;
    String signDateA;
    String signDateB;
    String nameA;
    String nameB;
    TableRenderData items;
}
