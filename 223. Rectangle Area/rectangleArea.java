class Solution {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    static class Rectangle {
        private Point topLeft;
        private Point topRight;
        private Point bottomLeft;
        private Point bottomRight;

        public Rectangle(int x1, int y1, int x2, int y2) {
            Point bottomLeft = new Point(x1, y1);
            this.bottomLeft = bottomLeft;
            Point topRight = new Point(x2, y2);
            this.topRight = topRight;
            Point topLeft = new Point(x1, y2);
            this.topLeft = topLeft;
            Point bottomRight = new Point(x2, y1);
            this.bottomRight = bottomRight;
        }

        public Point getBottomLeft() {
            return this.bottomLeft;
        }

        public Point getBottomRight() {
            return this.bottomRight;
        }

        public Point getTopLeft() {
            return this.topLeft;
        }

        public Point getTopRight() {
            return this.topRight;
        }

        public int getArea() {
            return Math.abs(this.bottomLeft.getX() - this.topRight.getX())
                    * Math.abs(this.bottomLeft.getY() - this.topRight.getY());
        }
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        Rectangle rectA = new Rectangle(ax1, ay1, ax2, ay2);
        Rectangle rectB = new Rectangle(bx1, by1, bx2, by2);

        int xIntersect = (Math.min(rectA.getTopRight().getX(), rectB.getTopRight().getX())
                - Math.max(rectA.getBottomLeft().getX(), rectB.getBottomLeft().getX()));

        int yIntersect = (Math.min(rectA.getTopRight().getY(), rectB.getTopRight().getY())
                - Math.max(rectA.getBottomLeft().getY(), rectB.getBottomLeft().getY()));

        int areaIntersect = 0;
        if (xIntersect > 0 && yIntersect > 0) {
            areaIntersect = xIntersect * yIntersect;
        }
        return rectA.getArea() + rectB.getArea() - areaIntersect;
    }
}