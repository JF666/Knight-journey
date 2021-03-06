package HorseTravel;

class Travel {
    int chessboard[][];
    String result="";
    String response="";
    int[] xx,yy;
    Travel(int n,int x,int y) {
        this.chessboard=new int[n][n];
        xx=new int[n*n];
        yy=new int[n*n];
        this.start(x-1,y-1);
        result=result.substring(0,result.length()-2);
    }
    private class Point{
        int x,y;
        Point(int x,int y){
            int n=Travel.this.chessboard.length;
            if(x>=0&&x<n&&y>=0&&y<n){
                this.x=x;
                this.y=y;
            }
        }
        public String toString(){
            return "("+(this.x+1)+","+(this.y+1)+")";
        }
    }
    private void start(int x,int y){
        Point p=new Point(x,y);
        int count=1,direction=1;
        int n=this.chessboard.length;
        while (count<=n*n&&direction!=0){
            xx[count-1]=p.x+1;
            yy[count-1]=p.y+1;
            this.chessboard[p.x][p.y]=count;
            result+=p.toString()+"->";
            direction=this.select(p);
            if(direction==0&&count<n*n){
                response+="第"+count+"步，不通！";
            }
            else{
                count++;
                p=this.goaStep(p,direction);
            }
            if(count==n*n){
                response+="可以走完！";
            }
        }
    }
    private int select(Point p){
        int direction=0,minroad=8;
        for (int i=0;i<=8;i++){
            int road=0;
            Point next1=goaStep(p,i);
            if(next1!=null) {
                for (int j = 1; j <= 8; j++) {
                    Point next2=goaStep(next1,j);
                    if(next2!=null) {
                        road++;
                    }
                }
                if(road<minroad){
                    minroad=road;
                    direction=i;
                }
            }
        }
        return direction;
    }
    private Point goaStep(final Point p,int direction) {
        int x = p.x, y = p.y;
        switch (direction) {
            case 1:
                x -= 2;
                y++;
                break;
            case 2:
                x--;
                y += 2;
                break;
            case 3:
                x++;
                y += 2;
                break;
            case 4:
                x += 2;
                y++;
                break;
            case 5:
                x += 2;
                y--;
                break;
            case 6:
                x++;
                y -= 2;
                break;
            case 7:
                x--;
                y -= 2;
                break;
            case 8:
                x -= 2;
                y--;
                break;
        }
        int n = this.chessboard.length;
        if (x >= 0 && x < n && y >= 0 && y < n && this.chessboard[x][y] == 0) {
            return new Point(x, y);
        }
        return null;
    }
}