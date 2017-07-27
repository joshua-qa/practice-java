package Joshua.Synap.Ladder;

public class Vertex {
    int height;
    int currentPoint;
    int targetPoint;

    public Vertex(int h, int x, int y) {
        this.height = h;
        this.currentPoint = x;
        this.targetPoint = y;
    }

    public int getHeight() {
        return height;
    }

    public int getCurrentPoint() {
        return currentPoint;
    }

    public int getTargetPoint() {
        return targetPoint;
    }
}
