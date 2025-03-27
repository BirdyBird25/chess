//Buket Guner
//King is the piece
//My piece is a bishop-knight hybrid, being able to move both diagnol and in an L-Shape.
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class SuperKing extends Piece{
    
  //Pre Condition: It has a color and an image
  //Post Condition: This is the constructor that calls super from the superclass Piece in order to inherit from it
    public SuperKing(boolean color, String img) {
       
        super(color, img);
        
    }

  
    public String toString() {
      return "A" + super.toString() + img;
    }
    
  
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.

    //Pre condition: there is a board that works, and there are squares on the board
    //Post condition: returns an arrayList of squares that are controlled
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {

      ArrayList<Square> controlledSquares= new ArrayList<>();


      for (int r = start.getRow()+1; r < board.length; r++) {
        //and to the right 
        for (int c = start.getCol()+1; c < board[r].length; c++) {

          if (!(board[r][c].isOccupied())) {
            controlledSquares.add(board[r][c]);
          }
          
        }

      }
      
      //look above
      for (int r2 = start.getRow() - 1; r2 >= 0; r2--) {
          //and to the left
        for (int c2 = start.getCol() + 1; c2 < board[r2].length; c2++) {
          
          if (!(board[r2][c2].isOccupied())) {
            controlledSquares.add(board[r2][c2]);
          }
          

            }
          

        }
      

      for (int r3 = start.getRow() + 1; r3 < board.length; r3++) {
        //and to the left
      for (int c3 = start.getCol() - 1; c3 >= 0; c3--) {
        
        if (!(board[r3][c3].isOccupied())) {
          controlledSquares.add(board[r3][c3]);
        }
        

          }
        

      }
    

    for (int r4 = start.getRow() - 1; r4 >= 0; r4--) {
      //and to the left
    for (int c4 = start.getCol() - 1; c4 < board[r4].length; c4--) {
      
      if (!(board[r4][c4].isOccupied())) {
        controlledSquares.add(board[r4][c4]);
      }
      

        }
      

    }
  

  for (int r5 = 0; r5 < board.length; r5++) {

    for (int c5 = 0; c5 < board[c5].length; c5++) {

      if ((start.getCol() + 1 < 8) && start.getRow() + 1 < 8) {

        if (r5 + 2 < 8 && c5 + 1< 8 && !(board[r5 + 2][c5 + 1].isOccupied())) {
          controlledSquares.add(board[r5 + 2][c5 + 1]);
        }

        if (r5 + 2 < 8 && c5 - 1 >= 0 && !(board[r5 + 2][c5 - 1]).isOccupied()) {
          controlledSquares.add(board[r5 + 2][c5 - 1]);
        }

        if (r5 + 1 < 8 && c5 + 2 < 8 && !(board[r5 + 1][c5 + 2]).isOccupied()) {
          controlledSquares.add(board[r5 + 1][c5 + 2]);
        }

        if (r5 - 1 >= 0 && c5 + 2 < 8 && !(board[r5 - 1][c5 + 2]).isOccupied()) {
          controlledSquares.add(board[r5 - 1][c5 + 2]);
        }

        if (r5 - 1 >= 0 && c5 - 2 >= 0 && !(board[r5 - 1][c5 - 2]).isOccupied()) {
          controlledSquares.add(board[r5 - 2][c5 - 1]);
        }

        if (r5 - 2 >= 0 && c5 + 1 < 8 && !(board[r5 - 2][c5 + 1]).isOccupied()) {
          controlledSquares.add(board[r5 - 1][c5 - 2]);
          }

        if (r5 - 2 >= 0 && c5 - 1 >= 0 && !(board[r5 - 2][c5 - 1]).isOccupied() && board[r5 - 1][c5 - 2].getColor()) {
          controlledSquares.add(board[r5 - 1][c5 - 2]);   

      }

    }
   

  }

      return controlledSquares;

}

      return controlledSquares;

    }


    //   for (int r = 0; r < board.length; r++) {
    //     for (int c = 0; c < board[r].length; c++) {
    //       if (start.getLegalMoves(this, fromMoveSquare).contains(endSquare)) {
    //         controlledSquares.add(endSquare);
    //       }
    //     }
    //   }


    //  return null;

    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.

    //My piece is going to move both diagonolly and in the L-shape, so it's going to be a knight-bishop hybrid
    //Pre condition: there is an existent board and existing squares
    //Post condition: this will return an arraylist of moves that are considered legal
    
    public ArrayList<Square> getLegalMoves(Board b, Square start){

      ArrayList<Square> moves = new ArrayList<Square>();

      Square[][] board = b.getSquareArray();

      //if ((start.getCol() + 1 < 8) && start.getRow() + 1 < 8) {

      //look below
      for (int r = start.getRow()+1, c = start.getCol()+1; r < board.length && c < board[r].length; r++, c++) {
        //and to the right 
      

          if (!(b.getSquareArray()[r][c].isOccupied())) {
            moves.add(b.getSquareArray()[r][c]);
          }
          else {
            //is it the same color as me? break otherwise add that square and then break
            if (b.getSquareArray()[r][c].getOccupyingPiece().getColor() == color ) { // == == start.getColor()??
              break;
            }
            else {
              moves.add(b.getSquareArray()[r][c]);
              break;
            }

            }
          

        }
      
  //     //look above
       for (int r2 = start.getRow() - 1, c2 = start.getCol() + 1; r2 >= 0 && c2 < board[r2].length; r2--, c2++) {
  //         //and to the right
         
          
          if (!(b.getSquareArray()[r2][c2].isOccupied())) {
            moves.add(b.getSquareArray()[r2][c2]);
          }
          else {
            //is it the same color as me? break otherwise add that square and then break
            if (b.getSquareArray()[r2][c2].getOccupyingPiece().getColor() == color ) {
              break;
            }
            else {
              moves.add(b.getSquareArray()[r2][c2]);
              break;
            }

            }
          

        }
  //     }

       for (int r3 = start.getRow() + 1, c3 = start.getCol() - 1; r3 < board.length && c3 >= 0; r3++, c3--) {
         //and to the left
         if (!(b.getSquareArray()[r3][c3].isOccupied())) {
           moves.add(b.getSquareArray()[r3][c3]);
         }
         else {
           //is it the same color as me? break otherwise add that square and then break
           if (b.getSquareArray()[r3][c3].getOccupyingPiece().getColor() == color ) {
             break;
           }
           else {
             moves.add(b.getSquareArray()[r3][c3]);
             break;
          }

          }
        

      }
    

     for (int r4 = start.getRow() - 1, c4 = start.getCol() - 1; r4 >= 0 && c4 >=0; r4--, c4--) {
       //and to the left
      
       if (!(b.getSquareArray()[r4][c4].isOccupied())) {
         moves.add(b.getSquareArray()[r4][c4]);
       }
       else {
         //is it the same color as me? break otherwise add that square and then break
         if (b.getSquareArray()[r4][c4].getOccupyingPiece().getColor() == color ) {
           break;
         }
         else {
           moves.add(b.getSquareArray()[r4][c4]);
           break;
        }

        }
      

     }

    return moves;

}

}





