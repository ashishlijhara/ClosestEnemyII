import java.util.*;
import java.io.*;

class Main {
    public static int ClosestEnemyII(String[] strArr) {
        Coordinate ally = new Coordinate(-1, -1);
        List<Coordinate> enemies = new ArrayList<>();

        // Nustatome pradines koordinates draugo ir prieso
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr.length; j++) {
                if (strArr[j].charAt(i) == '1') {
                    ally = new Coordinate(i, j);
                } else if (strArr[j].charAt(i) == '2') {
                    enemies.add(new Coordinate(i, j));
                }
            }
        }

        // Pajudiname matrica i desine ir apacia kad apskaiciuotume atstumus
        int closestEnemy = Integer.MAX_VALUE;
        int endIndex = strArr.length - 1;
        for (int i = 0; i < endIndex + 1; i++) {
            System.out.println();
            Coordinate newAlly = new Coordinate(
                    (ally.x + i > endIndex ? (ally.x + i - 1) % endIndex : ally.x + i),
                    (ally.y + i > endIndex ? (ally.y + i - 1) % endIndex : ally.y + i));
            for (Coordinate enemy : enemies) {
                Coordinate newEnemy = new Coordinate(
                        (enemy.x + i > endIndex ? (enemy.x + i - 1) % endIndex : enemy.x + i),
                        (enemy.y + i > endIndex ? (enemy.y + i - 1) % endIndex : enemy.y + i));
                int distance = newAlly.distance(newEnemy);
                if (distance < closestEnemy) {
                    closestEnemy = distance;
                }
            }
        }
        return (closestEnemy == Integer.MAX_VALUE ? 0 : closestEnemy);
    }

    // Helper classe kuri laiko x ir x koordinates draugo ir prieso
    private static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int distance(Coordinate c) {
            return Math.abs(this.x - c.x) + Math.abs(this.y - c.y);
        }
    }

    public static void main (String[] args) {
    
        Scanner s = new Scanner(System.in);
        System.out.print(ClosestEnemyII(s.nextLine())); // on Intellij something doesnt work with this??? Didn't fix this problem yet :/

    }

}
