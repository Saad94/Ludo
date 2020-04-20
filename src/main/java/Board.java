import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class Board {

    public static final Position RED_START             = new Position(13, 6, true);
    public static final Position RED_HOME_ENTRANCE     = new Position(14, 7, false);
    public static final Position RED_HOME_START        = new Position(13, 7, false);
    public static final Position GREEN_START           = new Position(6,  1, true);
    public static final Position GREEN_HOME_ENTRANCE   = new Position(7,  0, false);
    public static final Position GREEN_HOME_START      = new Position(7,  1, false);
    public static final Position YELLOW_START          = new Position(1,  8, true);
    public static final Position YELLOW_HOME_ENTRANCE  = new Position(0,  7, false);
    public static final Position YELLOW_HOME_START     = new Position(1,  7, false);
    public static final Position BLUE_START            = new Position(8,  13,true);
    public static final Position BLUE_HOME_ENTRANCE    = new Position(7,  14,false);
    public static final Position BLUE_HOME_START       = new Position(7,  13, false);

    public static final Player RED    = new Player(Color.RED,    RED_START,    RED_HOME_ENTRANCE,    RED_HOME_START);
    public static final Player GREEN  = new Player(Color.GREEN,  GREEN_START,  GREEN_HOME_ENTRANCE,  GREEN_HOME_START);
    public static final Player YELLOW = new Player(Color.YELLOW, YELLOW_START, YELLOW_HOME_ENTRANCE, YELLOW_HOME_START);
    public static final Player BLUE   = new Player(Color.BLUE,   BLUE_START,   BLUE_HOME_ENTRANCE,   BLUE_HOME_START);

    public static final List<Position> POSITIONS             = new ArrayList<>();
    public static final List<Position> RED_HOME_POSITIONS    = new ArrayList<>();
    public static final List<Position> GREEN_HOME_POSITIONS  = new ArrayList<>();
    public static final List<Position> YELLOW_HOME_POSITIONS = new ArrayList<>();
    public static final List<Position> BLUE_HOME_POSITIONS   = new ArrayList<>();
    public static final List<List<Pane>> PANES               = new ArrayList<>();
}
