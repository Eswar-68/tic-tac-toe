import java.util.*;
public class TTT{
	static int board_size=3;
	static char[][] board=new char[board_size][board_size];
	static char player='X';
	public static void main(String args[]){
		Scanner sc =new Scanner(System.in);
		int row,col;
		initializeBoard();
		while(true){
			printBoard();
			System.out.println("Player "+player+"'s turn (row and column):");
			row=sc.nextInt();
			col=sc.nextInt();
			if(row<0||row>board_size-1||col<0||col>board_size-1||board[row][col]!=' ')
				System.out.println("Invalid move");
			else{
				board[row][col]=player;
				if(isGameOver()){
					printBoard();
					System.out.println("Player "+player+" won!");
					break;
				}
				if(isBoardFull()){
					printBoard();
					System.out.println("Tie");
					break;
				}
				player=(player=='X')?'O':'X';
			}
		}
	}
	public static void initializeBoard(){
		for(int i=0;i<board_size;i++)
			for(int j=0;j<board_size;j++)
				board[i][j]=' ';
	}
	public static void printBoard(){
		System.out.println("  0 1 2");
		for(int i=0;i<board_size;i++){
			System.out.print(i+" ");
			for(int j=0;j<board_size;j++){
				System.out.print(board[i][j]);
				if(j<board_size-1)
					System.out.print('|');
			}
			System.out.println();
			if(i<board_size-1)
				System.out.println("  -----");
		}
	}
	public static boolean isBoardFull(){
		for(int i=0;i<board_size;i++)
			for(int j=0;j<board_size;j++)
				if(board[i][j]==' ')
					return false;
		return true;
	}
	public static boolean isGameOver(){
		for(int i=0;i<board_size;i++){
			if((board[i][0]==player&&board[i][1]==player&&board[i][2]==player)||(board[0][i]==player&&board[1][i]==player&&board[2][i]==player))
				return true;
		}
		if((board[0][0]==player&&board[1][1]==player&&board[2][2]==player)||(board[0][2]==player&&board[1][1]==player&&board[2][0]==player))
			return true;
		return false;
	}
}