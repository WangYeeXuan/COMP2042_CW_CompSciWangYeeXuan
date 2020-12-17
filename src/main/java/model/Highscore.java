package model;

import java.io.*;

import java.util.ArrayList;

/**
 * This class is responsible for the arranged display of the scores at the leaderboard
 * @author E.B. Wang
 *
 */
public class Highscore{

	private String root = System.getProperty("user.dir");
	private String scoreFile = root+"\\src\\main\\resources\\score\\Score_file.txt";
	private int maxScores = 10;
	private ArrayList<HighScore> scoreList;
	
	/**
	 * This method is to read the text from the Score_file
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public Highscore() throws NumberFormatException, IOException {
		
		String line;
		String[] parts;
		int score;
		
		scoreList = new ArrayList<HighScore>(maxScores);
					
		BufferedReader file = new BufferedReader(new FileReader(scoreFile));

		while ((line = file.readLine()) != null) {
			
			parts = line.split("\t", 2);
			
			score = Integer.parseInt(parts[1]);

			scoreList.add(new HighScore(parts[0], score));
			
		}

		file.close();
		
	}
	
	/**
	 * This method is to get the array scorelist
	 * @return 
	 */
	public String[] Get_score_list() {
		
		String[] list = new String[scoreList.size()];
		
		for (int i = 0; i < scoreList.size() ; i++){
			
			list[i] = scoreList.get(i).toString();
			
		}
		
		return list;
		
	}
	
	/**
	 * This method write the new score in the Score_file if the score is more than the lowest score
	 * @param name
	 * @param score
	 * @throws IOException
	 */
	public void New_score(String name, int score) throws IOException {
		
		if (this.New_highscore(score)) {
			
			name = name.trim();
			
			if (!name.isEmpty()) {
				
				this.Add(name, score);
				Write_score_file();
				
			}

		}
		
	}
	
	/**
	 * This method is to check if the score is higher than the lowest score on the leaderboard
	 * @param score
	 * @return
	 */
	private boolean New_highscore(int score) {
		
		if(scoreList.size() < 10) {
			
			return true;
			
		}
		
		HighScore lowestHighScores = scoreList.get(scoreList.size() - 1);
		
		if (score < lowestHighScores.score) {
			
			return false;
			
		}
		else { 
		
			return true;
			
		}
	}
	
	/**
	 * This methos is to write into the Score_file
	 * @throws IOException
	 */
	private void Write_score_file() throws IOException {
			
		FileWriter write = new FileWriter(scoreFile);
		PrintWriter out = new PrintWriter(write);

		for (int i = 0; i < scoreList.size() && i < 10; i++){
			
			out.println(scoreList.get(i));
			
		}
			
		out.close();
		
	}
	
	/**
	 * This method is to add the scores and arranged it in ascending order
	 * @param name
	 * @param score
	 */
	private void Add(String name, int score) {
		scoreList.add(new HighScore(name, score));
		int min_element; 
		int temp_score;        
		String temp_name;     
		
		for(min_element = scoreList.size() - 1; min_element >= 0; min_element --) {
			
			for(int i = 0; i <= min_element - 1; i++){
				
				if(scoreList.get(i).score < scoreList.get(i + 1).score) {
					
					temp_score = scoreList.get(i).score;
					scoreList.get(i).score = scoreList.get(i + 1).score;
					scoreList.get(i + 1).score = temp_score;
					
					temp_name = scoreList.get(i).name;
					scoreList.get(i).name = scoreList.get(i + 1).name;
					scoreList.get(i+1).name = temp_name;
					
				}
				
			}
			
		}
		
		if (scoreList.size() > 10) {
			
			for(int i = 10; scoreList.size() > i ; i++)
			
			scoreList.remove(i);
			
		}
		
	}
	
	private static class HighScore {
		
		public String name;
		public int score;

		public HighScore(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public String toString() {
			return name + "\t" + score;
		}
		
	}
	
}
