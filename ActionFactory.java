package action;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() { }
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		switch(command) {
		case "board_list": action = new BoardListAction(); break;
		case "board_detail": action = new BoardDetailAction(); break;
		}
		return action;
	}
}
