package com.codecool;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    public int n = 0;
    private Scanner scanner;
    private Pawn[][] board;
    private String letters= "A B C D E F G H I J K L M N O P R S T U ";




    public Pawn[][] Board() {

        this.scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please type an integer between 10 & 20 to specify board size: ");
            String user_input = this.scanner.nextLine();
            this.n = Integer.parseInt(user_input);
            if (this.n <= 20 && this.n >= 10) {
                break;
            }
        }
        Pawn[][] board = new Pawn[this.n][this.n];


        return board;
    }
    public void setPawn (Pawn object, Pawn[][]board){
        board[object.coordinates.getX()][object.coordinates.getY()] = object;
    }
    public void removePawn(Pawn object,Pawn[][] board){
        board[object.coordinates.getX()][object.coordinates.getY()]=null;
    }
    public void setNewCordinates(int x,int y,Pawn object){
        object.coordinates.setX(x);
        object.coordinates.setY(y);
    }
    public void movePawn(Pawn object,Pawn[][] board,int x,int y){
        if(board[x][y]==null){
            removePawn(object,board);
            setNewCordinates(x,y,object);
            setPawn(object,board);}

    }
    public void deletePawn(ArrayList<Pawn> list,Pawn object,Pawn[][] board){
        removePawn(object,board);
        list.remove(list.indexOf(object));

    }
    public void printBoard(Pawn[][] board) {
        System.out.println("   "+letters.substring(0,(board.length*2)));
        System.out.println("---"+"-".repeat(board.length*2));
        for (int row = 0; row < board.length; row++) {
            if (row<9){System.out.print(row+1+" | ");}
            else{System.out.print(row+1+"| ");}
            for (int element = 0; element < board[row].length; element++) {
                if (board[row][element]==null){
                    System.out.print("□ ");}
                else {
                    if (board[row][element].toString() == "white") {
                        System.out.print("W ");
                    }
                    else {
                        System.out.print("B ");
                    }
                }
            }
            System.out.printf("\n");
        }


    }
    public ArrayList<Pawn> createWhitePawns(int n,Pawn[][] board,ArrayList<Pawn>whitePawns){
        for (int i=0;i<n;i++){
            if(i<(n/2)) {
                Pawn object = new Pawn("white",n - 1, ((i * 2) + 1) );
                setPawn(object,board);
                whitePawns.add(object);

            }
            else{Pawn object = new Pawn("white",n - 2,((i -(n/2)) * 2));
                setPawn(object,board);
                whitePawns.add(object);}
        }
        return whitePawns;
    }
    public ArrayList<Pawn> createBlackPawns(int n,Pawn[][] board,ArrayList<Pawn>blackPawns){
        for (int i=0;i<n;i++){
            if(i<(n/2)) {
                Pawn object = new Pawn("black",1, ((i * 2) + 1) );
                setPawn(object,board);
                blackPawns.add(object);

            }
            else{Pawn object = new Pawn("black",0,((i -(n/2)) * 2));
                setPawn(object,board);
                blackPawns.add(object);}
        }
        return blackPawns;
    }

}

