package n.rnu.isetr.boardxo;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GameBoardUI gameBoard;
    private Button playAgainButton;
    private TextView playerTurn;
    private String[] playerNames = {"Player X", "Player O"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        playAgainButton = findViewById(R.id.playAgainButton);
         playerTurn = findViewById(R.id.displayTurn);

        playAgainButton.setVisibility(View.GONE);

        gameBoard = findViewById(R.id.TicTacToeGameBoard);


        if (playerNames != null) {
            playerTurn.setText((playerNames[0]));
        }

        gameBoard.setUpGame(playAgainButton, playerTurn, playerNames);
    }

    public void playAgainPress(View view){
        gameBoard.resetGame();
        gameBoard.invalidate();
    }

}