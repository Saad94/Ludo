import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Piece {

    private static final int PIECE_SIZE = 10;

    private final Player player;
    private final Circle circle;

    private Position position;

    public Piece(Player player) {
        this.player = player;
        this.circle = new Circle(PIECE_SIZE, player.getColor());
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
        circle.setStrokeType(StrokeType.INSIDE);
        circle.relocate(PIECE_SIZE, PIECE_SIZE);
    }
}
