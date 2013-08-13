package util;
import gameEngine.Ship;
import gameEngine.Weapon;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;


public final class Utils {

    private Utils() {
    }
    
    public static int extractFromDash(String argument){
    	int dash = argument.indexOf("-");
    	argument = argument.substring(dash+1, argument.length());
    	dash = argument.indexOf("-");
    	argument = argument.substring(0, dash);
    	int value = Integer.parseInt(argument);
    	return value;
    }
    
     public static String[] elementsFromString(String str){
    	String one = "";
    	String two = "";
    	String three = "";
    	str = str.trim();
    	int end = 0;
    	int space = str.indexOf(" ");
    	if(space == -1 && end != 1){
    		one = str.substring(0, str.length());
    		end = 1;
    	}else if (end != 1){
    		one = str.substring(0, space);
    	}
    	if (space != -1){
    		str = str.substring(space, str.length());
    	}
    	str = str.trim();
    	space = str.indexOf(" ");
    	if(space == -1 && end != 1){
    		two = str.substring(0, str.length());
    		end = 1;
    	}else if (end != 1){
    		two = str.substring(0, space);
    	}
    	if (space != -1){
    		str = str.substring(space, str.length());
    	}
    	str = str.trim();
    	space = str.indexOf(" ");
    	if(space == -1 && end != 1){
    		three = str.substring(0, str.length());
    		end = 1;
    	}else if (end != 1){
    		three = str.substring(0, space);
    	}
    	String[] temp = {one, two, three};
    	return temp;
     }    
    public static int determineDamage(Ship attacker, Weapon weapon, Ship defender){
    	int damage = weapon.damage() * attacker.weaponPower();
    	
    	String face = whichFace(attacker, defender);
    	double shields = 0;
    	if(face.equals("front")){
    		shields = defender.frontShieldDecimal();    		
    	} else if (face.equals("left")){
    		shields = defender.leftShieldDecimal();
    	} else if (face.equals("right")){
    		shields = defender.rightShieldDecimal();
    	} else if (face.equals("rear")){
    		shields = defender.rearShieldDecimal();
    	}
    	
    	if (shields > 1 ){
    		shields = 1;
    	}
    	
    	if (weapon.typeNum() != 1){
    		damage = (int) (damage*(1-shields));
    	}
    	if (weapon.typeNum() != 3){
    		damage += defender.instability();
    	}
      	if (weapon.typeNum() == 2){
    		damage += defender.instability();
    	}
   	
    	return damage;
    }
    
    
    /**
     * Calculates distance between ship one and ship two
     * @param one
     * @param two
     * @return
     */
    public static int findDistance(Ship one, Ship two){
    	
    	double toBeSquared = (one.posX() * one.posX()) + (two.posX() * two.posX()) + (one.posY() * one.posY()) + (two.posY() * two.posY());
    	
    	int distance = (int) Math.sqrt(toBeSquared);
    	
    	
    	return distance;
    }
   
    /**
     * Finds the nearest Ship to ship of the list of Ship's ships
     * @param ship
     * @param ships
     * @return
     */
    public static Ship findNearest(Ship ship, List<Ship> ships){
    	Ship nearest = ships.get(0);
    	int listSize = ships.size();
    	int shortestDistance = findDistance(ship, ships.get(0));
    	for (int i = 1; i < listSize; i++){
    		int newDistance = findDistance(ship, ships.get(i));
    		if(newDistance < shortestDistance){
    			shortestDistance = newDistance;
    			nearest = ships.get(i);
    		}
    	}
    	
    	return nearest;
    }

    /**
     * This finds the ship that is within the ships view, within range, and returns only the closest.
     * @param ship
     * @param range
     * @param ships
     * @return returns non real ship is there is none.
     */
    public static Ship keepBestTarget(Ship ship, int range, List<Ship> ships){
    	List<Ship> targets = removeNotInArc(ship, ships);
    	targets = findWithenRadius(ship, range, targets);
    	Ship best = new Ship();
    	if (targets.size() > 0){
    		best = findNearest(ship, targets);
    	}
    	return best;
    }

    public static List<Ship> keepTargets(Ship ship, int range, List<Ship> ships){
    	List<Ship> targets = removeNotInArc(ship, ships);
    	targets = findWithenRadius(ship, range, targets);
    	return targets;
    }
    
    /**
     * Removes from the ships any ship that is not in given arc of ship.
     * @param ship
     * @param a direction on a 16 numbered clock. The arc is +/- 2 from the given angle.    
     * @param ships
     * @return
     */
    public static List<Ship> removeNotInArc(Ship ship, List<Ship> ships){
    	return removeNotInArc(ship, ship.facing(), ships);
    }
 
    /**
     * Removes from ships any ship that is not within the given radius of the given ship
     * @param ship
     * @param radius
     * @param ships
     * @return
     */
    public static List<Ship> findWithenRadius(Ship ship, int radius, List<Ship> ships){
    	List<Ship> withen = new ArrayList<Ship>();
    	int listSize = ships.size();
    	for (int i = 0; i < listSize; i++){
    		int newDistance = findDistance(ship, ships.get(i));
    		if(newDistance < radius){
    			withen.add(ships.get(i));
    		}
    	}
    	
    	return withen;
    }
    
        /**
     * Calculates distance between ship one and ship two
     * @param one
     * @param two
     * @return
     */
    public static int findDistance(int x1, int y1, int x2, int y2){
    	
    	double toBeSquared = (x1 * x1) + (x2 * x2) + (y1 * y1) + (y2 * y2);
    	
    	int distance = (int) Math.sqrt(toBeSquared);
    	
    	
    	return distance;
    }
     
        /**
     * Calculates distance between ship one and ship two
     * @param one
     * @param two
     * @return
     */
    public static double findExactDistance(int x1, int y1, int x2, int y2){
    	
    	double toBeSquared = (x1 * x1) + (x2 * x2) + (y1 * y1) + (y2 * y2);
    	
    	double distance = Math.sqrt(toBeSquared);
    	
    	
    	return distance;
    }  

    /**
     * Finds the nearest Ship to ship of the list of Ship's ships
     * @param ship
     * @param ships
     * @return
     */
    public static Ship findNearest(int x, int y, List<Ship> ships){
    	Ship nearest = ships.get(0);
    	int listSize = ships.size();
    	int shortestDistance = findDistance(x, y, ships.get(0).posX(), ships.get(0).posY());
    	for (int i = 1; i < listSize; i++){
    		int newDistance = findDistance(x, y, ships.get(i).posX(), ships.get(i).posY());
    		if(newDistance < shortestDistance){
    			shortestDistance = newDistance;
    			nearest = ships.get(i);
    		}
    	}
    	
    	return nearest;
    }

    /**
     * This finds the ship that is within the ships view, within range, and returns only the closest.
     * @param ship
     * @param range
     * @param ships
     * @return returns non real ship is there is none.
     */
    public static Ship keepBestTarget(Ship ship, int facing, int range, List<Ship> ships){
    	List<Ship> targets = removeNotInArc(ship, facing, ships);
    	targets = findWithenRadius(ship, range, targets);
    	Ship best = new Ship();
    	if (targets.size() > 0){
    		best = findNearest(ship, targets);
    	}
    	return best;
    }

    public static List<Ship> keepTargets(Ship ship, int facing, int range, List<Ship> ships){
    	List<Ship> targets = removeNotInArc(ship, facing, ships);
    	targets = findWithenRadius(ship, range, targets);
    	return targets;
    }
    
    /**
     * Removes from the ships any ship that is not in given arc of ship.
     * @param ship
     * @param a direction on a 16 numbered clock. The arc is +/- 2 from the given angle.    
     * @param ships
     * @return
     */
    public static List<Ship> removeNotInArc(Ship ship, int facing, List<Ship> ships){
    	List<Ship> withen = new ArrayList<Ship>();   	
    	
    	// you have a point and two angles
    	int x = ship.posX();
    	int y = ship.posY();
    	int a = facing- 2;
    	int b = facing + 2;
    	
    	if(a == 0 ){
    		a = 16;
    	} else if (a == -1){
    		a = 15;
    	}
    	if(b == 17){
    		b = 1;
    	}else if (b == 18){
    		b = 2;
    	}

    	// determine the lines
    	Line lineA = new Line(x, y, a);
    	Line lineB = new Line(x, y, b);
    	
    	// loop through the list of ships, if its x and y values fall within the required range (describe below), then add it to the list of ships to return
    	// if facing anything left (so 9-15) then you need to be to the left of both line.
    	// if facing anything right (1-7) then you need to be to the right of both lines.
    	// if facing up (16) then you need to be to the right of line a and to the left of line b.
    	// if facing down (8) then you need to be left of line a and to the right of line b.
    	
    	int length = ships.size();
    	int dir = 0;
    	if (facing == 16){
    		dir = 1;
    	}else if (facing >= 1 && facing <= 7){
    		dir = 2;
    	}else if (facing == 8){
    		dir = 3;
    	}else if (facing >= 9 && facing <= 15){
    		dir = 4;
    	}
    	for(int i = 0; i < length; i++){
    		boolean isIn = false;
    		boolean sideOfA = false;
    		boolean sideOfB = false;
    		int x2 = ships.get(i).posX();
    		int y2 = ships.get(i).posY();

    		if (dir == 1){
    			if(lineA.isHorizontal() && lineA.pointIsAbove(x2, y2)){
    				sideOfA = true;
    			} else if(!lineA.isHorizontal() && !lineA.pointIsLeft(x2, y2)){
    				sideOfA = true;
    			}
    			if(lineB.isHorizontal() && lineB.pointIsAbove(x2, y2)){
    				sideOfB = true;
    			} else if(!lineB.isHorizontal() && lineB.pointIsLeft(x2, y2)){
    				sideOfB = true;
    			}
    			if (sideOfA && sideOfB){
    				isIn = true;
    			}
    		} else if (dir == 2){
    			if(lineA.isHorizontal() && !lineA.pointIsAbove(x2, y2)){
    				sideOfA = true;
    			} else if(!lineA.isHorizontal() && !lineA.pointIsLeft(x2, y2)){
    				sideOfA = true;
    			}
    			if(lineB.isHorizontal() && lineB.pointIsAbove(x2, y2)){
    				sideOfB = true;
    			} else if(!lineB.isHorizontal() && lineB.pointIsLeft(x2, y2)){
    				sideOfB = true;
    			}
    			if (sideOfA && sideOfB){
    				isIn = true;
    			}
    		} else if (dir == 3){
    			if(lineA.isHorizontal() && !lineA.pointIsAbove(x2, y2)){
    				sideOfA = true;
    			} else if(!lineA.isHorizontal() && !lineA.pointIsLeft(x2, y2)){
    				sideOfA = true;
    			}
    			if(lineB.isHorizontal() && !lineB.pointIsAbove(x2, y2)){
    				sideOfB = true;
    			} else if(!lineB.isHorizontal() && lineB.pointIsLeft(x2, y2)){
    				sideOfB = true;
    			}
    			if (sideOfA && sideOfB){
    				isIn = true;
    			}    		} else if (dir == 4){
    			if(lineA.isHorizontal() && lineA.pointIsAbove(x2, y2)){
    				sideOfA = true;
    			} else if(!lineA.isHorizontal() && !lineA.pointIsLeft(x2, y2)){
    				sideOfA = true;
    			}
    			if(lineB.isHorizontal() && !lineB.pointIsAbove(x2, y2)){
    				sideOfB = true;
    			} else if(!lineB.isHorizontal() && lineB.pointIsLeft(x2, y2)){
    				sideOfB = true;
    			}
    			if (sideOfA && sideOfB){
    				isIn = true;
    			}
    		}
    		if (isIn){
    			withen.add(ships.get(i));
    		}
    		
    	}
    	
    	return withen;
    }
    
    /**
     * Removes from ships any ship that is not within the given radius of the given ship
     * @param ship
     * @param radius
     * @param ships
     * @return
     */
    public static List<Ship> findWithenRadius(int x, int y, int radius, List<Ship> ships){
    	List<Ship> withen = new ArrayList<Ship>();
    	int listSize = ships.size();
    	for (int i = 0; i < listSize; i++){
    		int newDistance = findDistance(x, y, ships.get(i).posX(), ships.get(i).posY());
    		if(newDistance < radius){
    			withen.add(ships.get(i));
    		}
    	}
    	
    	return withen;
    }
    
    /**
     * This function takes in two ships. it returns which arc of shipOne that shipTwo is in
     * @param ship
     * @param otherShip
     * @return
     */    public static String whichFace(Ship shipOne, Ship shipTwo){

    	List<Ship> ships = new ArrayList<Ship>();
    	ships.add(shipTwo);
    	ships = Utils.removeNotInArc(shipOne, shipOne.facing(), ships);
    	if (ships.size() == 1){
    		return "front";
    	} 
    	ships = Utils.removeNotInArc(shipOne, shipOne.leftFace(), ships);
     	if (ships.size() == 1){
    		return "left";
    	}   
    	ships = Utils.removeNotInArc(shipOne, shipOne.rightFace(), ships);
    	if (ships.size() == 1){
    		return "right";
    	}
    	ships = Utils.removeNotInArc(shipOne, shipOne.rearFace(), ships);
    	if (ships.size() == 1){
    		return "rear";
    	}
    	return "none"; // should never happen
    }
    /*
    public static int[] giveMovement(int deltaSide, int deltaForward, int facing){
    	int[] deltaXY = {1,2};
    	Line line = new Line(0, 0 , deltaSide, deltaForward);
    	double distance = findExactDistance(0, 0, deltaSide, deltaForward);

    	double changeSlope = facing * 22.5;

    	line.addDegToSlope(changeSlope);

    	double[] point = findPointFromOrigin(distance, line.m);

    	int intPoint = findNearestWholePoint(point[0], point[1]);

    	return intPoint;
    }	
   */ 

      public static int[] giveMovement(int deltaSide, int deltaForward, int facing){

    	double changeSlope = facing * 22.5 - 270;

    	double x = -1*Math.cos(Math.toRadians(changeSlope))*deltaForward + ((-1 * Math.sin(Math.toRadians(changeSlope)))*deltaSide);
    	double y = Math.sin(Math.toRadians(changeSlope))*deltaForward + (Math.cos(Math.toRadians(changeSlope))*deltaSide);
    	
    	int intX = (int) x;
    	int intY = (int) y;
    	int[] newDelta = {intX, intY};
    	
    	return newDelta;
    }	  

}
