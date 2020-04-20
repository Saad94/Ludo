import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.Data;
import lombok.experimental.Accessors;

public class Main extends Application {

    private final SetupService setupService = new SetupService();
    private static final GameService gameService   = new GameService();

    @Override
    public void start(final Stage stage) throws Exception {
        Board board = new Board();
        Scene scene = setupService.setup();

        Piece piece1 = new Piece(Board.RED).setPosition(Board.RED.getStartPosition());
        Piece piece2 = new Piece(Board.RED).setPosition(Board.RED.getHomeEntrancePosition());
        Piece piece3 = new Piece(Board.GREEN).setPosition(Board.GREEN.getStartPosition());
        Piece piece4 = new Piece(Board.GREEN).setPosition(Board.GREEN.getHomeEntrancePosition());
        Piece piece5 = new Piece(Board.YELLOW).setPosition(Board.YELLOW.getStartPosition());
        Piece piece6 = new Piece(Board.YELLOW).setPosition(Board.YELLOW.getHomeEntrancePosition());
        Piece piece7 = new Piece(Board.BLUE).setPosition(Board.BLUE.getStartPosition());
        Piece piece8 = new Piece(Board.BLUE).setPosition(Board.BLUE.getHomeEntrancePosition());

//        gameService.drawPiece(board, piece1);
//        gameService.drawPiece(board, piece2);
//        gameService.drawPiece(board, piece3);
//        gameService.drawPiece(board, piece4);
//        gameService.drawPiece(board, piece5);
//        gameService.drawPiece(board, piece6);
//        gameService.drawPiece(board, piece7);
//        gameService.drawPiece(board, piece8);

        gameService.drawPiece(piece1);

        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(0.2), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                gameService.movePiece(piece1);
            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
//        gameService.movePiece(piece1);
//        gameService.movePiece(piece1);
//        gameService.movePiece(piece1);
//        gameService.movePiece(piece1);

        scene.getStylesheets().add("game.css");
        stage.setTitle("Ludo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(final String[] args) {
        Application.launch(args);
    }
}
