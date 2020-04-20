import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@RequiredArgsConstructor
public class Position {

    private final int row;
    private final int column;
    private final boolean stop;
    private final List<Piece> pieces = new ArrayList<>();

    private Position next;
}
