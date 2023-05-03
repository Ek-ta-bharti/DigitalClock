
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

class MyFrame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat monthFormat;
    SimpleDateFormat yearFormat;

    JLabel timeLabel;
    JLabel dayMonthYearLable;

    JLayeredPane layeredPane;
    // JPanel layeredPane;
    JPanel labelPanel;

    String time;
    String day;
    String month;
    String year;

    Color transparent;

    MyFrame() {
        transparent = new Color(0, 0, 0, 1);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 800);
        this.getContentPane().setBackground(Color.black);
        // this.setLayout(null);

        layeredPane = new JLayeredPane();
        // layeredPane = new JPanel();
        layeredPane.setBackground(transparent);
        layeredPane.setLayout(null);

        labelPanel = new JPanel();
        labelPanel.setBounds(1, 0, getWidth(), getHeight());
        labelPanel.setBackground(transparent);
        labelPanel.setLayout(null);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("E");
        monthFormat = new SimpleDateFormat("MMM");
        yearFormat = new SimpleDateFormat("yy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 45));
        timeLabel.setBackground(Color.red);
        timeLabel.setOpaque(true);

        timeLabel.setBounds(180, 200, 350, 100);

        dayMonthYearLable = new JLabel();
        dayMonthYearLable.setFont(new Font("Dialog", Font.PLAIN, 30));
        dayMonthYearLable.setBackground(Color.red);
        dayMonthYearLable.setOpaque(true);

        dayMonthYearLable.setBounds(250, 270, 200, 100);

        labelPanel.add(timeLabel);
        labelPanel.add(dayMonthYearLable);

        layeredPane.add(labelPanel, new Integer(2));

        BackgroundPanel bgPanel = new BackgroundPanel();
        bgPanel.setBounds(0, 0, getWidth(), getHeight());
        bgPanel.setBackground(transparent);

        layeredPane.add(bgPanel, new Integer(1));

        this.add(layeredPane);
        this.setVisible(true);

        setTime();

    }

    private void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            month = monthFormat.format(Calendar.getInstance().getTime());
            year = yearFormat.format(Calendar.getInstance().getTime());

            dayMonthYearLable.setText(day + " " + month + " " + year);
        }
    }
}

class BackgroundPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.RED);
        g.fillArc(70, 50, 500, 500, 0, 360);

        g.setColor(Color.black);
        g.fillArc(70, 50, 500, 500, 0, -180);

        g.setColor(Color.RED);
        int x[] = { 570, 70, 310 };
        int y[] = { 300, 300, 650 };
        int n = 3;
        g.fillPolygon(x, y, n);

        g.setColor(Color.BLACK);
        int a[] = { 480, 315, 180 };
        int b[] = { 15, 120, 20 };
        int c = 3;
        g.fillPolygon(a, b, c);
        // END DESIGN BACKGROUND
    }
}
