import java.io.*;
import java.util.*;

/*This is possibly a spaghetti code, future changes might be done*/

public class d4 {
    public static void main(String[] args) throws IOException{

        ArrayList<Integer> _order = new ArrayList<Integer>();
        ArrayList<Board> _boards = new ArrayList<Board>();

        BufferedReader reader = new BufferedReader(new FileReader("input4.txt"));
        
        String nums = reader.readLine();
        String[] number = nums.split(",");

        for (int i=0; i < number.length; i++)
            _order.add(Integer.parseInt(number[i]));

        while ((nums = reader.readLine()) != null){

            Board b = new Board();
            _boards.add(b);

            for (int i=0; i < 5; i++){
                nums = reader.readLine();
                number = nums.trim().split("\\s+");
                b.processLine(number, i);
            }

        }
        reader.close();

        int res;

        part1:
        for (int i=0; i < _order.size(); i++){

            for (Board b : _boards){

                b.searchNumber(_order.get(i));
                if (b.checkCols() || b.checkRows()){
                    System.out.println(b.allUnmarkedNumbers() * _order.get(i));
                    break part1;
                }

            }
        }

        Board lastBoard = null;
        ArrayList<Board> _copyBoards = new ArrayList<>();

        for (Board b : _boards){
            b.resetBoard();
            _copyBoards.add(b);
        }

        part2:
        for (int i=0; i < _order.size(); i++){

            for (Board b : _boards){

                if (b.isDone())
                    continue;

                if (_copyBoards.size() == 1){
                    lastBoard = _copyBoards.get(0);
                    System.out.println(lastBoard.simulateLastBoard(_order.subList(i, _order.size())));
                    return;
                }

                b.searchNumber(_order.get(i));

                if (b.checkCols() || b.checkRows()){
                    _copyBoards.remove(b);
                    continue;
                }

            }

            if (_copyBoards.size() == 1){
                lastBoard = _copyBoards.get(0);
                System.out.println(lastBoard.simulateLastBoard(_order.subList(i + 1, _order.size())));;
                return;
            }
        }

    }
}