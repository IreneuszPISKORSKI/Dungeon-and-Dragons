package Board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    List<BoardBox> boardList = new ArrayList<>();
    public void add(int position, String name){
        BoardBox box = createBox(position, name);
        boardList.add(box);
//        System.out.println(boardList);
    }

    public void edit(int position, String name){
        BoardBox box = createBox(position, name);
        int index = findIndex(position);
        if (index<0){
            System.out.println("Gdzies jest blad z indexem w opcji edit");
            return;
        }
        boardList.set(index, box);
    }

    public void delete(int position){
        int index = findIndex(position);
        if (index<0){
            System.out.println("Gdzies jest blad w opcji delete");
            return;
        }
        boardList.remove(index);
    }

    public void readAll(){
        for (BoardBox box : boardList) {
            System.out.println(box);
        }
    }

    BoardBox createBox(int position, String name){
        return new BoardBox(position, name);
    }

    public int findIndex(int position){
        int expectedIndex = -1;
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).position == position){
                expectedIndex = i;
                break;
            }
        }
        return expectedIndex;
    }

    public void elementsOnBoard(){
        Map<String, Integer> elementsOnBoard = new HashMap<>();
        for (BoardBox box: boardList) {
            if (elementsOnBoard.get(box.name)==null){
                elementsOnBoard.put(box.name, 1);
            }else {
                int oldCounter = elementsOnBoard.get(box.name);
                elementsOnBoard.put(box.name, oldCounter + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : elementsOnBoard.entrySet()) {
            System.out.println("position: " + entry.getKey() + " value: " + entry.getValue());
        }
    }

    public boolean letsTry(int position){
        return boardList.get(position).name.equals("0");
    }

    public String interactionBoardPlayer(int position){
        System.out.println(position);
        return boardList.get(position-1).name;
    }
}
