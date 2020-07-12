package finalProject.newServer;

public class Protocol {

    String Delimiter = ";";

    //Client sends:
    String Creategame = "CREATEGAME";
    String Findgames = "FINDGAMES";
    String Joingame = "JOINGAME";
    String Sendmessage = "SENDMESSAGE";
    String Requestleaderboard = "REQUESTLEADERBOARD";

    //Server sends:
    String Startgame = "STARTGAME";
    String Turn = "TURN";
    String Invalidmove = "INVALIDMOVE";
    String Game = "GAME";
    String Player = "PLAYER";
    String Endgame = "ENDGAME";
    String Error = "ERROR";
    String Chat = "CHAT";
    String Sendleaderboard = "SENDLEADERBOARD";
    String Toofewarguments = "TOOFEWARGUMENTS";

    //Both send:
    String Move = "MOVE";
    String Leavegame = "LEAVEGAME";
}

