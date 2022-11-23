package Board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    List<BoardBox> boardList = new ArrayList<>();
    public void add(int position, Box box1){
        BoardBox box = createBox(position, box1);
        boardList.add(box);
    }

    public void edit(int position, Box box1){
        BoardBox box = createBox(position, box1);
//        System.out.println("edit pos: " + position);
//        System.out.println("edit index: " + findIndex(position));
        if (findIndex(position)<0){
            System.out.println("Gdzies jest blad z indexem w opcji edit");
            return;
        }
        boardList.set(findIndex(position), box);
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

    BoardBox createBox(int position, Box name){
        return new BoardBox(position, name);
    }

    public int findIndex(int position){
        int expectedIndex = -1;
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getPosition() == position){
                expectedIndex = i;
                break;
            }
        }
        return expectedIndex;
    }

    public void elementsOnBoard(){
        Map<String, Integer> elementsOnBoard = new HashMap<>();
        for (BoardBox box: boardList) {
            if (elementsOnBoard.get(box.getName())==null){
                elementsOnBoard.put(box.getName(), 1);
            }else {
                int oldCounter = elementsOnBoard.get(box.getName());
                elementsOnBoard.put(box.getName(), oldCounter + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : elementsOnBoard.entrySet()) {
            System.out.println("position: " + entry.getKey() + " value: " + entry.getValue());
        }
    }

    public boolean letsTry(int position){
        return boardList.get(position).getName().equals("0");
    }

    public void nameOnPosition(int position){
        System.out.println(boardList.get(position).getName());
    }

    public void interactionBoardPlayer(int position){
        boardList.get(position-1).getHave().interact();
    }

    //take random digit as dice throw, return 1-6
    public int diceThrow() {
        return (int) (Math.random() * 6 + 1);
    }

    public int randomEnemyOnBoard(){
        //random between 11 and 62
        return (int) (Math.random()* 52 + 11);
    }
    public int randomBonusOnBoard(){
        //random between 1 and 63
        return (int) (Math.random()* 63 + 1);
    }
    public int randomWeaponOnBoard(){
        //random between 1 and 40
        return (int) (Math.random()* 40 + 1);
    }


}
