import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameService {

    public void drawPiece(Piece piece) {
        Pane currentPane = getCurrentPane(piece);
        currentPane.getChildren().add(piece.getCircle());
    }

    public void movePiece(Piece piece) {
        Pane currentPane = getCurrentPane(piece);
        currentPane.getChildren().remove(piece.getCircle());
        piece.setPosition(piece.getPosition().getNext());
        currentPane = getCurrentPane(piece);
        currentPane.getChildren().add(piece.getCircle());
    }

    private Pane getCurrentPane(Piece piece) {
        return Board.PANES.get(piece.getPosition().getColumn()).get(piece.getPosition().getRow());
    }
}
