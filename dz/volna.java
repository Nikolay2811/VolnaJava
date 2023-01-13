package dz;
import java.util.LinkedList;
import java.util.Queue;

class Point2D{
    int x;
    int y;
    public Point2D(int x1, int y1){
        x = x1;
        y = y1;
    }
}


public class volna {
    public static void CalculateVolna(int[][] map, Point2D start) {
        Queue<Point2D> queue = new LinkedList<Point2D>();
        queue.add(start);
        map[start.x][start.y] = 1;
    
        while (queue.size() != 0) {
          Point2D p = queue.remove();
          
          if (map[p.x - 1][p.y] == 0) {
            queue.add(new Point2D(p.x - 1, p.y));
            map[p.x - 1][p.y] = map[p.x][p.y] + 1;
          }
          if (map[p.x][p.y - 1] == 0) {
            queue.add(new Point2D(p.x, p.y - 1));
            map[p.x][p.y - 1] = map[p.x][p.y] + 1;
          }
          if (map[p.x + 1][p.y] == 0) {
            queue.add(new Point2D(p.x + 1, p.y));
            map[p.x + 1][p.y] = map[p.x][p.y] + 1;
          }
          if (map[p.x][p.y + 1] == 0) {
            queue.add(new Point2D(p.x, p.y + 1));
            map[p.x][p.y + 1] = map[p.x][p.y] + 1;
          }
        }

      }
      public static void PathFinder( int[][] map, Point2D start, Point2D finish){
        if (map[finish.x] [finish.y] == -1) 
        {
          System.out.println("Финиш в преграде");
          return;
      
        }

        int k = map[finish.x][finish.y];
        var tek = finish;
        System.out.println(" Начало пути -2 конец - 4, путь занимает "+(map[finish.x][finish.y]-1) +" шагов");

        while(k != 1){
          if(map[tek.x-1][tek.y] == k-1){            
            tek = new Point2D(tek.x-1, tek.y);            
          }
          if(map[tek.x+1][tek.y] == k-1){            
            tek = new Point2D(tek.x+1, tek.y);            
          }
          if(map[tek.x][tek.y-1] == k-1){            
            tek = new Point2D(tek.x, tek.y-1);            
          }
          if(map[tek.x+1][tek.y+1] == k-1){            
            tek = new Point2D(tek.x, tek.y+1);            
          }
          k--;
          
          map[tek.x][tek.y] = 0;
          map[start.x][start.y] = -2;
          map[finish.x][finish.y] = -4;
        }       

      }
      public static void printer(int[][] map){
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < map.length; row++) {
          for (int col = 0; col < map[row].length; col++) {
            sb.append(String.format("%5d", map[row][col]));
          }
          sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
          sb.append("\n");
        }
        System.out.println(sb.toString());
      }

  
    public static void main(String[] args){
        int[][] map = {
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
            { -1, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
            { -1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
            { -1, 00, 00, 00, -1, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
            { -1, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
            { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1 },
            { -1, -1, -1, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1 },
            { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, -1, -1, 00, 00, -1 },
            { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1 },
            { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1 },
            { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
            { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
            { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, -1 },
            { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
            { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
        };
    var start = new Point2D(2,4);
    var finish = new Point2D(3, 9);

    CalculateVolna(map, start);
    printer(map);    

    PathFinder(map, start, finish);
    printer(map);    

  }
}
