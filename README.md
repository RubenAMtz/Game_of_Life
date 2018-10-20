# Game of Life

Emulating the board game "Life, the game of life". Technologies used: JAVA

## Try it yourself:

Requirements:
- jre1.8.0_191
- Eclipse Release 4.8.0 (Photon)

# Install
git clone https://github.com/RubenAMtz/Game_of_Life/

Once you have the files in your local computer, run eclipse, define the working directory on the root directory of the repo. Then
execute the Main. Test cases that passed have been commented, note that some of them might be out of date since code keeps changing.

Enjoy.

## School project

## Four main classes have been developed so far:
- Node
- Tree
- Board
- Main

### Node
Basic structure of a node with only two possible connections, to two other nodes. It takes on three parameters, node type (string),
note reference (Node) and another node reference (Node).

### Tree
The tree is the structure that builds up, controls and connects the nodes together. It defines the methods for spliting and joining 
branches together.

### Board
This class holds the tree together, it takes on players type objects and moves them around the board.
NOTE: This is undertaking a minor change since controling players on the board should be something done by the class Game and not by
board.

### Next implementations:
New code is being developed to create a class that holds every type of block and its parameters together. It'll be created through the 
same node type (string) from node. This parameter will then be passed to a method that creates the block depending on the value of the
string.

