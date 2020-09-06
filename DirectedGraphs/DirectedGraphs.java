public class DirectedGraphs {
    public final int[][] Matrix;
    public static final int INF = 999999;
    //Infinity values for the Matrix can be replaced with values such as 99999 or just 999

    DirectedGraphs(int[][] Matrix){
        this.Matrix = Matrix;
    }
    public static class ShortestDistance extends DirectedGraphs{
        ShortestDistance(int[][] Matrix){super(Matrix);}

        public int[][] FloydsAlgo(int[][] Matrix, String PathOrMatrix){
            int[][] NewMatrix = Matrix.clone();
            for (int[] matrix : Matrix) {
                assert Matrix.length == matrix.length : "The Matrix is Invalid.";
            }
            int N = Matrix.length;
            int[][] Paths = new int[N][N];
            for(int z = 0; z < N; z++){
                for(int x = 0; x < N; x++){
                    for(int y = 0; y < N; y++){
                        if(Matrix[x][y] > Matrix[x][z] + Matrix[z][y]){
                            NewMatrix[x][y] = Matrix[x][z] + Matrix[z][y];
                            Paths[x][y] = z;
                        }
                    }
                }
            }
            if(PathOrMatrix.toLowerCase().equals("matrix")){
                return NewMatrix;
            }
            else if(PathOrMatrix.toLowerCase().equals("paths")){
                //gives you the intermediate node of the graph that creates the shortest distance
                return Paths;
            }
            else
                return NewMatrix;
        }

    }
}
