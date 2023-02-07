package com.codecool;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    String player1;
    String player2;
    Pawn[][] board;
    private Scanner scanner;
    private ArrayList<Pawn> whitePawns;

    private ArrayList<Pawn> blackPawns;

    public Game() {
        this.player1 = "White";
        this.player2 = "Black";
        this.board =null;
        this.whitePawns = new ArrayList();
        this.blackPawns = new ArrayList();
    }

    public void Game(){
        Board board= new Board();
        this.board = board.Board();
        this.whitePawns = board.createWhitePawns(board.n,this.board,whitePawns);
        this.blackPawns = board.createBlackPawns(board.n,this.board,blackPawns);
        ArrayList<Integer> cords = round();
        for (Pawn i:this.whitePawns
             ) {
            if(i.coordinates.getX()== cords.get(0) && i.coordinates.getY()== cords.get(1) && i.toString()=="white"){
                 board.movePawn(i,this.board,cords.get(2),cords.get(3));
        }


        }
        board.printBoard(this.board);



//        board.printBoard(this.board);
//        board.movePawn(this.whitePawns.get(0),this.board,5,5);
//        board.printBoard(this.board);
//        for (Pawn i:this.whitePawns
//             ) {if(i.coordinates.getX()==5 && i.coordinates.getY()==5){
//            System.out.println("bingo");
//            board.deletePawn(whitePawns,i,this.board);
//            break;
//
//        }
//
//
//        }
//        board.printBoard(this.board);
        }


    public ArrayList<Integer> round(){
        System.out.println("Please add coordinates pawn from (first Letter like A3) :");
        this.scanner = new Scanner(System.in);
        String user_input = this.scanner.nextLine();
        ArrayList<Integer> cord = convert(user_input);
        System.out.println("Please add coordinates pawn to (first Letter like A3) :");
        String user_input2 = this.scanner.nextLine();
        ArrayList<Integer> stopcord = convert(user_input2);
        cord.addAll(stopcord);
        return cord;






    }
    public ArrayList<Integer> convert(String coordinates){
        ArrayList<Integer> cord = new ArrayList<>();
        String letter = coordinates.substring(0,1);
        String strnumber = coordinates.substring(1);
        int number = Integer.parseInt(strnumber);
        int intletter = convertLetterToInt(letter.toUpperCase());
        cord.add(number-1);
        cord.add(intletter);
        return cord;


    }
    public int convertLetterToInt(String letter){
        String letters ="ABCDEFGHIJKLMNOPRSTU";
        return letters.indexOf(letter);
    }
        }





