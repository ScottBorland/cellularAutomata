package hello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class LangtonAnt extends GameObject {
    
    Environment environment;
    Handler handler;
    protected int dir;
    protected int UP, RIGHT, DOWN, LEFT;
    protected int state;

    public LangtonAnt(int x, int y, ID id, Handler handler, Environment environment) {
        super(x, y, id);
        this.handler = handler;
        this.environment = environment;
        dir = 0;
        UP = 0;
        RIGHT = 1;
        DOWN = 2;
        LEFT = 3;
    }

    public void tick(){
        for(int i = 0; i < 1; i++){
        state = this.environment.grid[this.x][this.y]; 
        if (state == 0) {
            turnRight();
            this.environment.grid[x][y] = 1;
          } else if (state == 1) {
            turnLeft();
            this.environment.grid[this.x][this.y] = 0;
          }   
        moveForward();    
        }
    }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x * Game.scale, y * Game.scale, 10, 10);
    }
    private void moveForward() {
        if (this.dir == UP) {
          this.y--;
        } else if (this.dir == RIGHT) {
          this.x++;
        } else if (this.dir == DOWN) {
          this.y++;
        } else if (this.dir == LEFT) {
          this.x--;
        }
        if (this.x > Game.WIDTH/Game.scale -1) {
          this.x = 0;
        } else if (this.x < 0) {
          this.x = Game.WIDTH/Game.scale -1;
        }
        if (this.y > Game.HEIGHT/Game.scale -1) {
          this.y = 0;
        } else if (this.y < 0) {
          this.y = Game.HEIGHT/Game.scale -1;
        }
      }
      private void turnLeft() {
        this.dir--;
        if (this.dir < UP) {
          this.dir = LEFT;
        }
      }
      private void turnRight() {
        this.dir++;
        if (this.dir > LEFT) {
          this.dir = UP;
        }
      }
}
