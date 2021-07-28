import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Sudoku1 extends JFrame implements ActionListener
{   
	JTextField box[][]=new JTextField[9][9];
	private int[][] puzzle =
      {{0, 7, 0, 0, 0, 0, 0, 0, 9},
       {5, 1, 0, 4, 2, 0, 6, 0, 0},
       {0, 8, 0, 3, 0, 0, 7, 0, 0},
       {0, 0, 8, 0, 0, 1, 3, 7, 0},
       {0, 2, 3, 0, 8, 0, 0, 4, 0},
       {4, 0, 0, 9, 0, 0, 1, 0, 0},
       {9, 6, 2, 8, 0, 0, 0, 3, 0},
       {0, 0, 0, 0, 1, 0, 4, 0, 0},
       {7, 0, 0, 2, 0, 3, 0, 9, 6}};
	public Sudoku1() {
      Container cp = getContentPane();
      cp.setLayout(new GridLayout(9, 9));
      for (int row = 0; row < 9; ++row) {
         for (int col = 0; col < 9; ++col) {
            box[row][col] = new JTextField(); 
            cp.add(box[row][col]);            
            if (puzzle[row][col]==0) {
               box[row][col].setText(""); 
			   
			box[row][col].setBackground(Color.WHITE);
			   final int row1=row;
			   final int col1=col;
				box[row][col].addMouseListener(new MouseAdapter(){
				@Override
		public void mouseClicked(MouseEvent e){
					
			box[row1][col1].setBackground(Color.GREEN);
                int no[]={1,2,3,4,5,6,7,8,9};
				for(int i=0;i<9;i++)
				{
					for(int j=0;j<9;j++)
					{if(puzzle[row1][i]==no[j] && puzzle[row1][i]!=0 && no[j]!=0)
					{
						no[j]=0;
					}if(puzzle[i][col1]==no[j] && puzzle[i][col1]!=0 && no[j]!=0)
					{
						no[j]=0;
					}}
				}
				int i=0;
				for(int j=0;j<9;j++)
					if(no[j]!=0)
						i++;
				
                   Object[] options = new Object[i];
				   i=0;
				   for(int j=0;j<9;j++)
					if(no[j]!=0)
							options[i++]=no[j];
int n = JOptionPane.showOptionDialog(cp,
    "select one",
    "select one number",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    5);
	if(n!=-1)
	{
	box[row1][col1].setText(""+options[n]);
	puzzle[row1][col1]=(int)options[n];
	
	}	   }
        });} 
		else {
               box[row][col].setText(""+puzzle[row][col]);
               box[row][col].setEditable(false);
            }
            box[row][col].setHorizontalAlignment(JTextField.CENTER);
            box[row][col].setFont(new Font("", Font.BOLD, 20));
			box[row][col].addActionListener(this);
			box[row][col].setEditable(false);
         }
      }
   }
   public void actionPerformed(ActionEvent e)
   { 
   
   //e.getsource(box[row][col]);
      System.out.println("hahahaha!");
     
		
   }
 
   public static void main(String[] args) {
	   Sudoku1 s=new Sudoku1();
	   s.setVisible(true);
	   s.setBounds(100,100,500,500);
   }
}
