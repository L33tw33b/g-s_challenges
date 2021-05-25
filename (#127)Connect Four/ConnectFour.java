import java.util.*;

public class ConnectFour //Connect Four game
{
    //Global variables 
    public static int select = 0; //Column which player wish to put their pieces
    public static int p1 = 1, p2 = 2; // Player's piece indicator
    public static int[][] gameboard = new int[6][7]; // Board
    public static Scanner kb = new Scanner(System.in); 
    public static int turn = 0; // Number of turns
    public static boolean quitted = false; // Exit the game when true. Refer to assign function

    public static void main(String[] args) { // The main program
	Draw(gameboard);
	while(!checkwin(gameboard) && turn != 42 && !quitted){
		turn++;
		checkturn();

	}
	if(turn == 42 && !checkwin(gameboard)){ 
		System.out.println("Stalemate!");
	}else if(checkwin(gameboard)){
		if(turn % 2 == 1){
			System.out.print("Player 1 win!");
		} else {
			System.out.print("Player 2 win!");
		}
	}
    }

    public static void Draw(int[][] board){ // Draw the Game Board
    	for(int row = 5; row>=0;row--){
		System.out.printf("%d | ",row);
		for(int col = 0;col<board[0].length;col++){
			System.out.printf("%d ",board[row][col]);
		}
		System.out.println();
	}
	System.out.println("    -------------");
	System.out.print("   ");
	for(int base = 0; base<board[0].length; base++){
		System.out.printf("%2d",base);
	}    	
	System.out.println();
    }

    public static boolean checkwin(int[][] board){ // Check if win
    	boolean win = false;
	int count = 0; // For checking consecutive pieces
	int dummy = 0; // Check gameboard element to be the same as dummy variable

	// variable x and y refers to their axis
	
	for(int x = 0; x<gameboard[0].length;x++){ //Check Vertical
		for(int y = 0; y<gameboard.length;y++){
			if(dummy == gameboard[y][x] && gameboard[y][x] != 0){
				count++;
			}else{
				dummy = gameboard[y][x];
				count = 1;
			}
			if(count == 4){
				return true;
			}
		}
		count = 0;
		dummy = 0; // Reset to default value
	}		
	
	for(int y = 0; y<gameboard.length-1;y++){ //Check Horizontal
		for(int x = 0; x<gameboard[0].length;x++){
			if(dummy == gameboard[y][x] && gameboard[y][x] != 0){
				count++;
			}else{
				dummy = gameboard[y][x];
				count = 1;
			}
			if(count == 4){
				return true;
			}
		}
		count = 0;
		dummy = 0; // Reset to default value
	}

	for(int y = 3; y < gameboard.length; y++){ //Check Diagonol from left (first half)
		for(int x = 0; x < y + 1; x++){
			if(dummy == gameboard[y-x][x] && gameboard[y-x][x] != 0) {
				count++;
			}else{
				dummy = gameboard[y-x][x];
				count = 1;
			}
			if(count == 4){
				return true;
			}
		}
		count = 0;
		dummy = 0;	
	}

	for(int x = 1; x < 4; x++){ //Check Diagonol from left(second half)
		for(int y = 0; y < 7-x ; y++){
			if(dummy == gameboard[5-y][x+y] && gameboard[5-y][x+y] != 0) {
				count++;
			}else{
				dummy = gameboard[5-y][x+y];
				count = 1;
			}
			if(count == 4){
				return true;
			}
		}
		count = 0;
		dummy = 0;
	}

	for(int y = 3; y < gameboard.length; y++){ //Check diagonol from right(first half)
		for(int x = 0; x < y + 1; x++){
			if(dummy == gameboard[y-x][6-x] && gameboard[y-x][6-x] != 0) {
				count++;
			}else{
				dummy = gameboard[y-x][6-x];
				count = 1;
			}
			if(count == 4){
				return true;
			}
		}
		count = 0;
		dummy = 0;	
	}

	for(int y = 0; y < 3; y++) { //Check diagonol from right(second half)
		for(int x = 0; x < 6-y; x++){
			if(dummy == gameboard[y+x][x] && gameboard[y+x][x] != 0){
				count++;
			}else{
				dummy = gameboard[y+x][x];
				count = 1;
			}
			if(count == 4){
				return true;
			}
		}
			count = 0;
			dummy = 0;
	}
	return win;
    }

    public static void assign(int pos){ // Assigning the player's piece to the board according to their input
	boolean full = true; // Check if column is full
	switch(pos){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		// Assign to board
		for(int i = 0; i<gameboard[0].length-1; i++){
			if(gameboard[i][pos] == 0){ //Checking whose turn it is in order to correctly insert piece
				if(turn % 2 == 1){
					gameboard[i][pos] = 1;
				} else {
					gameboard[i][pos] = 2;
				}
				full = false;
				break;
			}
		}
		if(full){
			System.out.println("Column " +pos+ " is full!");
			checkturn();
		}
		Draw(gameboard);
		break;
		case 9: System.out.print("Bye bye!");
		quitted = true;	//Quit game
		break;
		default: //Out of bound value	
		System.out.println("Range of column should be 0 to 6!");
		checkturn();
		break;
	}
    }

    public static void checkturn(){ //Check whose turn it is
	if (turn % 2 == 1){
	System.out.print("Player 1 type a column (0-6) or 9 to quit current game: ");
	} else {
	System.out.print("Player 2 type a column (0-6) or 9 to quit current game: ");
	}
	select = kb.nextInt();
	assign(select);   	
    }
}

