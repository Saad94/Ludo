import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class SetupService {

    private static final int NUM_DIMENSIONS = 15;
    private static final int BOX_DIMENSIONS = 40;
    private static final String CLASS_GAME_GRID      = "game-grid";
    private static final String CLASS_GAME_GRID_CELL = "game-grid-cell";
    private static final String CLASS_FIRST_COLUMN   = "first-column";
    private static final String CLASS_FIRST_ROW      = "first-row";
    private static final String CLASS_WHITE          = "white";
    private static final String CLASS_RED            = "red";
    private static final String CLASS_GREEN          = "green";
    private static final String CLASS_YELLOW         = "yellow";
    private static final String CLASS_BLUE           = "blue";
    private static final String CLASS_BLACK          = "black";
    private static final String CLASS_GREY           = "grey";
    private static final String CLASS_PURPLE         = "purple";

    private static final Integer[][] GRID_LOCATIONS = new Integer[][] {
            { 5, 5, 5, 5, 5, 5, 0, 0, 0, 5, 5, 5, 5, 5, 5 },
            { 5, 2, 2, 2, 2, 5, 0, 3, 3, 5, 3, 3, 3, 3, 5 },
            { 5, 2, 0, 0, 2, 5, 6, 3, 0, 5, 3, 0, 0, 3, 5 },
            { 5, 2, 0, 0, 2, 5, 0, 3, 0, 5, 3, 0, 0, 3, 5 },
            { 5, 2, 2, 2, 2, 5, 0, 3, 0, 5, 3, 3, 3, 3, 5 },
            { 5, 5, 5, 5, 5, 5, 0, 3, 0, 5, 5, 5, 5, 5, 5 },
            { 0, 2, 0, 0, 0, 0, 5, 7, 5, 0, 0, 0, 6, 0, 0 },
            { 0, 2, 2, 2, 2, 2, 7, 5, 7, 4, 4, 4, 4, 4, 0 },
            { 0, 0, 6, 0, 0, 0, 5, 7, 5, 0, 0, 0, 0, 4, 0 },
            { 5, 5, 5, 5, 5, 5, 0, 1, 0, 5, 5, 5, 5, 5, 5 },
            { 5, 1, 1, 1, 1, 5, 0, 1, 0, 5, 4, 4, 4, 4, 5 },
            { 5, 1, 0, 0, 1, 5, 0, 1, 0, 5, 4, 0, 0, 4, 5 },
            { 5, 1, 0, 0, 1, 5, 0, 1, 6, 5, 4, 0, 0, 4, 5 },
            { 5, 1, 1, 1, 1, 5, 1, 1, 0, 5, 4, 4, 4, 4, 5 },
            { 5, 5, 5, 5, 5, 5, 0, 0, 0, 5, 5, 5, 5, 5, 5 }
    };

    private static final Map<Integer, String> CLASS_MAP = new HashMap<Integer, String>() {{
        put(0, CLASS_WHITE);
        put(1, CLASS_RED);
        put(2, CLASS_GREEN);
        put(3, CLASS_YELLOW);
        put(4, CLASS_BLUE);
        put(5, CLASS_BLACK);
        put(6, CLASS_GREY);
        put(7, CLASS_PURPLE);
    }};

    public Scene setup() {
        setupPositions();

        GridPane grid = new GridPane();
        grid.getStyleClass().add(CLASS_GAME_GRID);

        for(int i = 0; i < NUM_DIMENSIONS; i++) {
            ColumnConstraints column = new ColumnConstraints(BOX_DIMENSIONS);
            grid.getColumnConstraints().add(column);
        }

        for(int i = 0; i < NUM_DIMENSIONS; i++) {
            RowConstraints row = new RowConstraints(BOX_DIMENSIONS);
            grid.getRowConstraints().add(row);
        }

        for (int i = 0; i < NUM_DIMENSIONS; i++) {
            Board.PANES.add(new ArrayList<>());

            for (int j = 0; j < NUM_DIMENSIONS; j++) {
                Pane pane = new Pane();
                pane.getStyleClass().add(CLASS_GAME_GRID_CELL);

                if (i == 0) {
                    pane.getStyleClass().add(CLASS_FIRST_COLUMN);
                }

                if (j == 0) {
                    pane.getStyleClass().add(CLASS_FIRST_ROW);
                }

                pane.getStyleClass().add(CLASS_MAP.get(GRID_LOCATIONS[j][i]));

                grid.add(pane, i, j);
                Board.PANES.get(i).add(pane);
            }
        }

        return new Scene(grid, (NUM_DIMENSIONS * BOX_DIMENSIONS) + 100, (NUM_DIMENSIONS * BOX_DIMENSIONS) + 100, Color.WHITE);
    }

    private void setupPositions() {
        Board.POSITIONS.addAll(Arrays.asList(
                Board.RED_HOME_ENTRANCE,
                new Position(14, 6,  false),
                Board.RED_START,
                new Position(12, 6,  false),
                new Position(11, 6,  false),
                new Position(10, 6,  false),
                new Position(9,  6,  false),
                new Position(8,  5,  false),
                new Position(8,  4,  false),
                new Position(8,  3,  false),
                new Position(8,  2,  true),
                new Position(8,  1,  false),
                new Position(8,  0,  false),
                Board.GREEN_HOME_ENTRANCE,
                new Position(6,  0,  false),
                Board.GREEN_START,
                new Position(6,  2,  false),
                new Position(6,  3,  false),
                new Position(6,  4,  false),
                new Position(6,  5,  false),
                new Position(5,  6,  false),
                new Position(4,  6,  false),
                new Position(3,  6,  false),
                new Position(2,  6,  true),
                new Position(1,  6,  false),
                new Position(0,  6,  false),
                Board.YELLOW_HOME_ENTRANCE,
                new Position(0,  8,  false),
                Board.YELLOW_START,
                new Position(2,  8,  false),
                new Position(3,  8,  false),
                new Position(4,  8,  false),
                new Position(5,  8,  false),
                new Position(6,  9,  false),
                new Position(6,  10, false),
                new Position(6,  11, false),
                new Position(6,  12, true),
                new Position(6,  13, false),
                new Position(6,  14, false),
                Board.BLUE_HOME_ENTRANCE,
                new Position(8,  14, false),
                Board.BLUE_START,
                new Position(8,  12, false),
                new Position(8,  11, false),
                new Position(8,  10, false),
                new Position(8,  9,  false),
                new Position(9,  8,  false),
                new Position(10, 8,  false),
                new Position(11, 8,  false),
                new Position(12, 8,  true),
                new Position(13, 8,  false),
                new Position(14, 8,  false)
        ));

        Board.RED_HOME_POSITIONS.addAll(Arrays.asList(
                Board.RED_HOME_START,
                new Position(12, 7, false),
                new Position(11, 7, false),
                new Position(10, 7, false),
                new Position(9, 7,  false),
                new Position(8, 7,  false)
        ));

        Board.GREEN_HOME_POSITIONS.addAll(Arrays.asList(
                Board.GREEN_HOME_START,
                new Position(7, 2, false),
                new Position(7, 3, false),
                new Position(7, 4, false),
                new Position(7, 5, false),
                new Position(7, 6, false)
        ));

        Board.YELLOW_HOME_POSITIONS.addAll(Arrays.asList(
                Board.YELLOW_HOME_START,
                new Position(2, 7, false),
                new Position(3, 7, false),
                new Position(4, 7, false),
                new Position(5, 7, false),
                new Position(6, 7, false)
        ));

        Board.BLUE_HOME_POSITIONS.addAll(Arrays.asList(
                Board.BLUE_HOME_START,
                new Position(7, 12, false),
                new Position(7, 11, false),
                new Position(7, 10, false),
                new Position(7, 9,  false),
                new Position(7, 8,  false)
        ));

        for (int i = 0; i < Board.POSITIONS.size(); i++) {
            if (i != Board.POSITIONS.size()-1) {
                Board.POSITIONS.get(i).setNext(Board.POSITIONS.get(i+1));
            } else {
                Board.POSITIONS.get(i).setNext(Board.POSITIONS.get(0));
            }
        }

        for (int i = 0; i < Board.RED_HOME_POSITIONS.size()-1; i++) {
            Board.RED_HOME_POSITIONS.get(i).setNext(Board.RED_HOME_POSITIONS.get(i+1));
        }

        for (int i = 0; i < Board.GREEN_HOME_POSITIONS.size()-1; i++) {
            Board.GREEN_HOME_POSITIONS.get(i).setNext(Board.GREEN_HOME_POSITIONS.get(i+1));
        }

        for (int i = 0; i < Board.YELLOW_HOME_POSITIONS.size()-1; i++) {
            Board.YELLOW_HOME_POSITIONS.get(i).setNext(Board.YELLOW_HOME_POSITIONS.get(i+1));
        }

        for (int i = 0; i < Board.BLUE_HOME_POSITIONS.size()-1; i++) {
            Board.BLUE_HOME_POSITIONS.get(i).setNext(Board.BLUE_HOME_POSITIONS.get(i+1));
        }
    }
}
