import java.util.Arrays;

/**
 * Leetcode problem #735, Asteroid Collision
 * https://leetcode.com/problems/asteroid-collision/
 * Implementing my own stack from the given input array
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = new int[] { 8, -8 };
        int[] res = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));
    }

    static int[] asteroidCollision(int[] asteroids) {
        int t = 0;
        for (int i = 1; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                asteroids[++t] = asteroids[i];
            } else {
                while (t >= 0 && asteroids[t] > 0 && (asteroids[t] < -asteroids[i])) {
                    t--;
                }

                if (t < 0 || asteroids[t] < 0) {
                    asteroids[++t] = asteroids[i];
                } else if (asteroids[t] == -asteroids[i]) {
                    t--;
                }
            }
        }

        int[] res = new int[t + 1];
        for (int i = 0; i <= t; i++) {
            res[i] = asteroids[i];
        }

        return res;
    }
}
