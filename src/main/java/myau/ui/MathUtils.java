package myau.ui;

public class MathUtils {

    public static float limit(float value, float min, float max) {
        if (value <= min) {
            return min;
        }
        return Math.min(value, max);
    }

    public static float limit(float value) {
        return limit(value, 0f, 1f);
    }

    public static double limit(double value, double min, double max) {
        if (value <= min) {
            return min;
        }
        return Math.min(value, max);
    }

    public static int limit(int value, int min, int max) {
        if (value <= min) {
            return min;
        }
        return Math.min(value, max);
    }

    public static float format(float value, float step, int decimals) {
        float quantized = Math.round(value / step) * step;
        int factor = (int) Math.pow(10, decimals);
        return Math.round(quantized * factor) / (float) factor;
    }

    public static float interpolate(float process, float start, float end) {
        return start + (end - start) * process;
    }
}
