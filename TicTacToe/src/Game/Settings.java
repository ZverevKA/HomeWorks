package Game;

import org.picocontainer.MutablePicoContainer;
import players.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ServiceLoader;
import org.picocontainer.DefaultPicoContainer;

public class Settings extends JFrame {

    public static void main(String[] args) {
        Settings settings = new Settings();
    }

    private ArrayList<String> plugArray;
    private String playerArray[] = {"HumanPlayer", "RandomBot", "WinTurnBot"};
    GameField gameField;
    public int size;
    public int turn;
    public int gameMode;
    public final int PLAYERVSBOT = 0;
    public final int BOTVSPLAYER = 1;
    public Player player0, player1;

    public Settings() {
        MutablePicoContainer container = new DefaultPicoContainer();
        container.addComponent(Game.class);
        Game game = container.getComponent(Game.class);
        plugArray = new ArrayList<>();
        for(PlugBot plugPlayer: ServiceLoader.load(PlugBot.class)){
            plugArray.add(plugPlayer.getName());
        }
        setTitle("Game.Settings");
        setBounds(250, 250, 300, 300);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JLabel labelSize = new JLabel("Select size of field");
        add(labelSize);
        JRadioButton button3 = new JRadioButton("3x3");
        JRadioButton button5 = new JRadioButton("5x5");
        button3.setSelected(true);
        add(button3);
        add(button5);
        ButtonGroup buttonGroupSize = new ButtonGroup();
        buttonGroupSize.add(button3);
        buttonGroupSize.add(button5);
        JLabel labelplayer0 = new JLabel("Select first player");
        add(labelplayer0);
        JComboBox boxplayer0 = new JComboBox();
        JComboBox boxplayer1 = new JComboBox();
        for (String name: playerArray){
            boxplayer0.addItem(name);
            boxplayer1.addItem(name);
        }
        for (String name: plugArray){
            boxplayer0.addItem(name);
            boxplayer1.addItem(name);
        }
        add(boxplayer0);
        JLabel labelplayer1 = new JLabel("Select second player");
        add(labelplayer1);
        add(boxplayer1);
        JButton startButton = new JButton("Start!");
        add(startButton);
        setVisible(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button3.isSelected()) {
                    size = 3;
                }
                if (button5.isSelected()) {
                    size = 5;
                }
                gameField = new GameField(size);
                for (PlugBot plugPlayer: ServiceLoader.load(PlugBot.class)){
                    if (((String) boxplayer0.getSelectedItem()).equals(plugPlayer.getName())){
                        player0 = (Player) plugPlayer;
                        player0.setTurn(gameField.PLAYER0);
                        player0.setGameField(gameField);
                    }
                }
                for (PlugBot plugPlayer: ServiceLoader.load(PlugBot.class)){
                    if (((String) boxplayer1.getSelectedItem()).equals(plugPlayer.getName())){
                        player1 = (Player) plugPlayer;
                        player1.setTurn(gameField.PLAYER1);
                        player1.setGameField(gameField);
                    }
                }
                if ((String) boxplayer0.getSelectedItem() == playerArray[0]) {
                    player0 = new HumanPlayer();
                    player0.setTurn(gameField.PLAYER0);
                    player0.setGameField(gameField);
                }
                if ((String) boxplayer0.getSelectedItem() == playerArray[1]) {
                    player0 = new RandomBot();
                    player0.setTurn(gameField.PLAYER0);
                    player0.setGameField(gameField);
                }
                if ((String)boxplayer0.getSelectedItem() == playerArray[2]) {
                    player0 = new WinTurnBot();
                    player0.setTurn(gameField.PLAYER0);
                    player0.setGameField(gameField);
                }
                if ((String) boxplayer1.getSelectedItem() == playerArray[0]) {
                    player1 = new HumanPlayer();
                    player1.setTurn(gameField.PLAYER1);
                    player1.setGameField(gameField);
                }
                if ((String) boxplayer1.getSelectedItem() == playerArray[1]) {
                    player1 = new RandomBot();
                    player1.setTurn(gameField.PLAYER1);
                    player1.setGameField(gameField);
                }
                if ((String)boxplayer1.getSelectedItem() == playerArray[2]) {
                    player1 = new WinTurnBot();
                    player1.setTurn(gameField.PLAYER1);
                    player1.setGameField(gameField);
                }
                game.start(player0, player1, gameField);
            }
        });
    }
}