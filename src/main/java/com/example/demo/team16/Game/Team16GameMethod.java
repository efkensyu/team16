package com.example.demo.team16.Game;



public class Team16GameMethod {
	
	//ボード作成メソッド
	public void createBoard(Team16GameForm form) {
		int[][] board = new int[8][8];
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 8; j++) {
	                board[i][j] = 0;
	            }
	        }
	        board[3][3] = 2;
		    board[3][4] = 1;
		    board[4][3] = 1;
		    board[4][4] = 2;
		 
			form.board=board;
	}
	
	//ボードセット
		public void setBoardBlack(Team16GameForm form,int x,int y) {
			form.board[y][x]=1;	
			for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 8; j++) {
	                if(form.board[i][j] == 3) {
	                	form.board[i][j]=0;
	                }
	            }
	        }
		}
		public void setBoardWhite(Team16GameForm form,int x,int y) {
			form.board[y][x]=2;	
			for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 8; j++) {
	                if(form.board[i][j] == 4) {
	                	form.board[i][j]=0;
	                }
	            }
	        }
		}
	
	//設置判定処理 黒
	public void checkBoardBlack(Team16GameForm form) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j <8; j++) {
				if(form.board[i][j]==0) {
					boolean b = false;
					//左上
					if (i >= 1 && j >= 1) {
					    int x = i - 1;
					    int y = j - 1;
					    boolean bb = false;
					    while (x >= 0 && y >= 0) {
					        if (form.board[x][y] == 2) {
					            bb = true;
					        }
					        else if (form.board[x][y] == 1) {
					            if (bb) {
					                b = true;
					            }
					            break;
					        }
					        else {
					            break;
					        }
					        x--;
					        y--;
					    }
					}
					
					//右上
					if (i >= 1 && j <= 6) {
					    int x = i - 1;
					    int y = j + 1;
					    boolean bb = false;
					    while (x >= 0 && y <= 7) {
					        if (form.board[x][y] == 2) {
					            bb = true;
					        }
					        else if (form.board[x][y] == 1) {
					            if (bb) {
					                b = true;
					            }
					            break;
					        }
					        else {
					            break;
					        }
					        x--;
					        y++;
					    }
					}
					
					
					//左下
					if (i <= 6 && j >= 1) {
					    int x = i + 1;
					    int y = j - 1;
					    boolean bb = false;
					    while (x <= 7 && y >= 0) {
					        if (form.board[x][y] == 2) {
					            bb = true;
					        }
					        else if (form.board[x][y] == 1) {
					            if (bb) {
					                b = true;
					            }
					            break;
					        }
					        else {
					            break;
					        }
					        x++;
					        y--;
					    }
					}
					
					//右下
					if (i <= 6 && j <= 6) {
					    int x = i + 1;
					    int y = j + 1;
					    boolean bb = false;
					    while (x <= 7 && y <= 7) {
					        if (form.board[x][y] == 2) {
					            bb = true;
					        }
					        else if (form.board[x][y] == 1) {
					            if (bb) {
					                b = true;
					            }
					            break;
					        }
					        else {
					            break;
					        }
					        x++;
					        y++;
					    }
					}
					
					
					//上
					if (i >= 1) {
					    int x = i - 1;
					    boolean bb = false;
					    while (x >= 0) {
					        if (form.board[x][j] == 2) {
					            bb = true;
					        }
					        else if (form.board[x][j] == 1) {
					            if (bb) {
					                b = true;
					            }
					            break;
					        }
					        else {
					            break;
					        }
					        x--;
					    }
					}
					
					//下
					if (i <= 6) {
					    int x = i + 1;
					    boolean bb = false;
					    while (x <= 7) {
					        if (form.board[x][j] == 2) {
					            bb = true;
					        }
					        else if (form.board[x][j] == 1) {
					            if (bb) {
					                b = true;
					            }
					            break;
					        }
					        else {
					            break;
					        }
					        x++;
					    }
					}
					
					//左
					if (j >= 1) {
					    int y = j - 1;
					    boolean bb = false;
					    while (y >= 0) {
					        if (form.board[i][y] == 2) {
					            bb = true;
					        }
					        else if (form.board[i][y] == 1) {
					            if (bb) {
					                b = true;
					            }
					            break;
					        }
					        else {
					            break;
					        }
					        y--;
					    }
					}
					
					
					//右
					if (j <= 6) {
					    int y = j + 1;
					    boolean bb = false;
					    while (y <= 7) {
					        if (form.board[i][y] == 2) {
					            bb = true;
					        }
					        else if (form.board[i][y] == 1) {
					            if (bb) {
					                b = true;
					            }
					            break;
					        }
					        else {
					            break;
					        }
					        y++;
					    }
					}
					
					if(b) {
						form.board[i][j]=3;
					}
					
				}
			}
		}
	}
	
	//設置判定処理 白
		public void checkBoardWhite(Team16GameForm form) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j <8; j++) {
					if(form.board[i][j]==0) {
						boolean b = false;
						//左上
						if (i >= 1 && j >= 1) {
						    int x = i - 1;
						    int y = j - 1;
						    boolean bb = false;
						    while (x >= 0 && y >= 0) {
						        if (form.board[x][y] == 1) {
						            bb = true;
						        }
						        else if (form.board[x][y] == 2) {
						            if (bb) {
						                b = true;
						            }
						            break;
						        }
						        else {
						            break;
						        }
						        x--;
						        y--;
						    }
						}
						
						//右上
						if (i >= 1 && j <= 6) {
						    int x = i - 1;
						    int y = j + 1;
						    boolean bb = false;
						    while (x >= 0 && y <= 7) {
						        if (form.board[x][y] == 1) {
						            bb = true;
						        }
						        else if (form.board[x][y] == 2) {
						            if (bb) {
						                b = true;
						            }
						            break;
						        }
						        else {
						            break;
						        }
						        x--;
						        y++;
						    }
						}
						
						
						//左下
						if (i <= 6 && j >= 1) {
						    int x = i + 1;
						    int y = j - 1;
						    boolean bb = false;
						    while (x <= 7 && y >= 0) {
						        if (form.board[x][y] == 1) {
						            bb = true;
						        }
						        else if (form.board[x][y] == 2) {
						            if (bb) {
						                b = true;
						            }
						            break;
						        }
						        else {
						            break;
						        }
						        x++;
						        y--;
						    }
						}
						
						//右下
						if (i <= 6 && j <= 6) {
						    int x = i + 1;
						    int y = j + 1;
						    boolean bb = false;
						    while (x <= 7 && y <= 7) {
						        if (form.board[x][y] == 1) {
						            bb = true;
						        }
						        else if (form.board[x][y] == 2) {
						            if (bb) {
						                b = true;
						            }
						            break;
						        }
						        else {
						            break;
						        }
						        x++;
						        y++;
						    }
						}
						
						
						//上
						if (i >= 1) {
						    int x = i - 1;
						    boolean bb = false;
						    while (x >= 0) {
						        if (form.board[x][j] == 1) {
						            bb = true;
						        }
						        else if (form.board[x][j] == 2) {
						            if (bb) {
						                b = true;
						            }
						            break;
						        }
						        else {
						            break;
						        }
						        x--;
						    }
						}
						
						//下
						if (i <= 6) {
						    int x = i + 1;
						    boolean bb = false;
						    while (x <= 7) {
						        if (form.board[x][j] == 1) {
						            bb = true;
						        }
						        else if (form.board[x][j] == 2) {
						            if (bb) {
						                b = true;
						            }
						            break;
						        }
						        else {
						            break;
						        }
						        x++;
						    }
						}
						
						//左
						if (j >= 1) {
						    int y = j - 1;
						    boolean bb = false;
						    while (y >= 0) {
						        if (form.board[i][y] == 1) {
						            bb = true;
						        }
						        else if (form.board[i][y] == 2) {
						            if (bb) {
						                b = true;
						            }
						            break;
						        }
						        else {
						            break;
						        }
						        y--;
						    }
						}
						
						
						//右
						if (j <= 6) {
						    int y = j + 1;
						    boolean bb = false;
						    while (y <= 7) {
						        if (form.board[i][y] == 1) {
						            bb = true;
						        }
						        else if (form.board[i][y] == 2) {
						            if (bb) {
						                b = true;
						            }
						            break;
						        }
						        else {
						            break;
						        }
						        y++;
						    }
						}
						
						if(b) {
							form.board[i][j]=4;
						}
						
					}
				}
			}
		}
}

