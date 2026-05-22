package com.example.demo.team16.Game;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
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
	
	//ボードリセット
	public void resetBoard(Team16GameForm form) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(form.board[i][j] == 3) {
					form.board[i][j]=0;
	             }
	         }
	     }
	}
	
	//集計
	public int resultBoard(Team16GameForm form){
		form.blackCount=0;
		form.whiteCount=0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(form.board[i][j] == 1) {
					form.blackCount++;
	             }
				if(form.board[i][j] == 2) {
					form.whiteCount++;
	             }
	         }
	     }
		int t = 0;
		if(form.blackCount>form.whiteCount) {
			t = 1;
		}else if(form.blackCount<form.whiteCount) {
			t = 2;
		}
		return t;
	}
	
	
	
	//ボードセット
	public void setBoard(Team16GameForm form,int x,int y,int n,int m) {
		form.board[y][x]=n;
			
		//左上
		int xx = x;
		int yy = y;
		boolean b = false;
		boolean bb = false;
		while (xx - 1 >= 0 && yy - 1 >= 0) {
			xx--;
			yy--;
			if (form.board[yy][xx] == m) {
				bb = true;
		     }
		     else if (form.board[yy][xx] == n) {
		    	 if (bb) {
		    		 b = true;
		         }
		         break;
		     }else {
		         break;
		     }
		}
		xx = x;
		yy = y;
		if(b) {
			while (xx - 1 >= 0 && yy - 1 >= 0) {
				xx--;
				yy--;
				if (form.board[yy][xx] == m) {
					form.board[yy][xx] = n;
				}else {
					break;
				}
		     }
		}
		
		//右上
		xx = x;
		yy = y;
		b = false;
		bb = false;
		while (xx + 1 <= 7 && yy - 1 >= 0) {
			xx++;
			yy--;
			if (form.board[yy][xx] == m) {
				bb = true;
		     }
		     else if (form.board[yy][xx] == n) {
		    	 if (bb) {
		    		 b = true;
		         }
		         break;
		     }else {
		         break;
		     }
		}
		xx = x;
		yy = y;
		if(b) {
			while (xx + 1 <= 7 && yy - 1 >= 0) {
				xx++;
				yy--;
				if (form.board[yy][xx] == m) {
					form.board[yy][xx] = n;
				}else {
					break;
				}
		     }
		}
		
		//左下
		xx = x;
		yy = y;
		b = false;
		bb = false;
		while (xx - 1 >= 0 && yy + 1 <= 7) {
			xx--;
			yy++;
			if (form.board[yy][xx] == m) {
				bb = true;
		     }
		     else if (form.board[yy][xx] == n) {
		    	 if (bb) {
		    		 b = true;
		         }
		         break;
		     }else {
		         break;
		     }
		}
		xx = x;
		yy = y;
		if(b) {
			while (xx - 1 >= 0 && yy + 1 <= 7) {
				xx--;
				yy++;
				if (form.board[yy][xx] == m) {
					form.board[yy][xx] = n;
				}else {
					break;
				}
		     }
		}
		
		//右下
		xx = x;
		yy = y;
		b = false;
		bb = false;
		while (xx + 1 <= 7 && yy + 1 <= 7) {
			xx++;
			yy++;
			if (form.board[yy][xx] == m) {
				bb = true;
		     }
		     else if (form.board[yy][xx] == n) {
		    	 if (bb) {
		    		 b = true;
		         }
		         break;
		     }else {
		         break;
		     }
		}
		xx = x;
		yy = y;
		if(b) {
			while (xx + 1 <= 7 && yy + 1 <= 7) {
				xx++;
				yy++;
				if (form.board[yy][xx] == m) {
					form.board[yy][xx] = n;
				}else {
					break;
				}
		     }
		}
		
		//上
		yy = y;
		b = false;
		bb = false;
		while (yy - 1 >= 0) {
			yy--;
			if (form.board[yy][x] == m) {
				bb = true;
		     }
		     else if (form.board[yy][x] == n) {
		    	 if (bb) {
		    		 b = true;
		         }
		         break;
		     }else {
		         break;
		     }
		}
		yy = y;
		if(b) {
			while (yy - 1 >= 0) {
				yy--;
				if (form.board[yy][x] == m) {
					form.board[yy][x] = n;
				}else {
					break;
				}
		     }
		}
		
		//下
		yy = y;
		b = false;
		bb = false;
		while (yy + 1 <= 7) {
			yy++;
			if (form.board[yy][x] == m) {
				bb = true;
		     }
		     else if (form.board[yy][x] == n) {
		    	 if (bb) {
		    		 b = true;
		         }
		         break;
		     }else {
		         break;
		     }
		}
		yy = y;
		if(b) {
			while (yy + 1 <= 7) {
				yy++;
				if (form.board[yy][x] == m) {
					form.board[yy][x] = n;
				}else {
					break;
				}
		     }
		}
		
		//左
		xx = x;
		b = false;
		bb = false;
		while (xx - 1 >= 0) {
			xx--;
			if (form.board[y][xx] == m) {
				bb = true;
		     }
		     else if (form.board[y][xx] == n) {
		    	 if (bb) {
		    		 b = true;
		         }
		         break;
		     }else {
		         break;
		     }
		}
		xx = x;
		if(b) {
			while (xx - 1 >= 0) {
				xx--;
				if (form.board[y][xx] == m) {
					form.board[y][xx] = n;
				}else {
					break;
				}
		     }
		}
		
		//右
		xx = x;
		b = false;
		bb = false;
		while (xx + 1 <= 7) {
			xx++;
			if (form.board[y][xx] == m) {
				bb = true;
		     }
		     else if (form.board[y][xx] == n) {
		    	 if (bb) {
		    		 b = true;
		         }
		         break;
		     }else {
		         break;
		     }
		}
		xx = x;
		if(b) {
			while (xx + 1 <= 7) {
				xx++;
				if (form.board[y][xx] == m) {
					form.board[y][xx] = n;
				}else {
					break;
				}
		     }
		}
		
		
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(form.board[i][j] == 3) {
					form.board[i][j]=0;
	             }
	         }
	     }
	}
	
	//設置判定処理 
	public boolean checkBoard(Team16GameForm form,int n,int m) {
		boolean pass1=false;
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
					        if (form.board[x][y] == m) {
					            bb = true;
					        }
					        else if (form.board[x][y] == n) {
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
					        if (form.board[x][y] == m) {
					            bb = true;
					        }
					        else if (form.board[x][y] == n) {
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
					        if (form.board[x][y] == m) {
					            bb = true;
					        }
					        else if (form.board[x][y] == n) {
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
					        if (form.board[x][y] == m) {
					            bb = true;
					        }
					        else if (form.board[x][y] == n) {
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
					        if (form.board[x][j] == m) {
					            bb = true;
					        }
					        else if (form.board[x][j] == n) {
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
					        if (form.board[x][j] == m) {
					            bb = true;
					        }
					        else if (form.board[x][j] == n) {
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
					        if (form.board[i][y] == m) {
					            bb = true;
					        }
					        else if (form.board[i][y] == n) {
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
					        if (form.board[i][y] == m) {
					            bb = true;
					        }
					        else if (form.board[i][y] == n) {
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
		for(int i = 0; i < 8 ; i++) {
			for(int j = 0; j < 8; j++) {
				if(form.board[i][j]==3) {
					pass1=true;
				}
			}
		}
		return pass1;
	}
	
	
	
	
	
}

