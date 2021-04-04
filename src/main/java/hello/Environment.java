package hello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Environment {

    protected int x, y;
    protected int cellWidth, cellHeight;
    public int [] [] grid;

    public Environment(int x, int y, int cellWidth, int cellHeight) {
        this.x = x;
        this.y = y;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        grid = new int [this.x][this.y];
        for(int i = 0; i < this.x; i++){
            for(int j = 0; j < this.y; j++){
                grid[i][j] = 0;
            }
        }
    }

    public void render(Graphics g){
        g.setColor(Color.black);
        for(int i = 0; i < this.x; i++){
            for(int j = 0; j < this.y; j++){
                if(grid[i][j] == 1){
                    g.fillRect(i*cellWidth, j*cellHeight, this.cellWidth, this.cellHeight);
                }
            }
        }
    }
}
