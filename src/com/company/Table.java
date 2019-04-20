package com.company;

public class Table {

    public int size;
    private GameManager game ;
    private Cell cells[][] ;



    Table(int size , GameManager game){
        this.game = game ;
        this.size = size ;
        cells = new Cell[size][size] ;
        setCells() ;
        print();
    }



    void setCells(){
        for(int i =0 ; i < this.size ; i++ ){
            for(int j = 0 ; j < this.size ; j++ ){
                cells[i][j] = new Cell(this , new Position(j,i)) ;
            }
        }
    }
    void addMarbleToCell(Cell cell , Marble marble){
        cell.addMarble(marble);
    }
    Cell getCell(Position position){
        if(position.isValid(size)){
            return cells[position.y][position.x] ;
        }
        else return null ;
    }


    /*===> Print Table<===*/

    private void topBarTable(){

        for(int i =0 ; i < size + 1 ; i++ ){
            if(i == 0){
                Helper.print(" ╔") ;
            }else if(i == (size) ){
                Helper.print("════╗") ;
            }
            else {
                Helper.print("════╦") ;
            }
        }
        Helper.print("\n");
    }
    private void downBarTable(){
        for(int i =0 ; i < size + 1  ; i++ ){
            if(i == 0){
                Helper.print(" ╚") ;
            }else if(i == (size ) ){
                Helper.print("════╝") ;
            }
            else {
                Helper.print("════╩") ;
            }
        }
        Helper.print("\n");
    }
    private void middleBarTable(){
        for(int i =0 ; i < size ; i++ ){
            if(i == 0){
                Helper.print(" ╠") ;
            }
            else {
                Helper.print("════╬") ;
            }
        }
        Helper.print("════╣") ;
        Helper.print("\n");
    }
    private void valueBarTable(Cell[] cell){
        for(int i =0 ; i < size ; i++ ){
            Helper.print("║  ");
            Helper.print((cell[i].isEmpty() ? " "  : cell[i].getMarble().marbleCharacter));
            Helper.print(" ");
        }
        Helper.print("║");
        Helper.print("\n");
    }
    public void print(){

        for(int i =0 ; i < size + 1 ; i++ ){
            if(i == 0){
                Helper.print("  ") ;
            }
            else {
                Helper.print(String.format("  %d  " , i-1)) ;
            }
        }

        Helper.print("\n");

        topBarTable();
        for(int i = 0 ; i < size ; i++ ){
            Helper.print(String.format("%d" , i));
            valueBarTable(this.cells[i]);
            if(i != size -1 ) middleBarTable();
        }
        downBarTable();

    }




}
