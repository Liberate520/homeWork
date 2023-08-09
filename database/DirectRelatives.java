//package database;
//
//import human.Gender;
//import human.Human;
//import relative.Relative;
//import tree.Node;
//
//import java.util.ArrayList;
//
//public class DirectRelatives extends Recearch  {
//
//
//        private ArrayList<Node> res = new ArrayList<>();
//        private Human root;
//
//
//        public String getParentsToString(Human root) {
//
//            StringBuilder sb = new StringBuilder();
//            for (Node node : this.res) {
//                if (node.getWho() == this.root  && (node.getRe() == Relative.parent)){
//
//                    sb.append(node.toString() + "\n");
//                }
//
////                if (node.getToWhom() == this.root &&
////                        ((node.getRe() == Relative.parent) || (node.getRe() == Type.mother))) {
////
////                    sb.append(node.toString() + "\n");
////                }
////            }
//            return sb.toString();
//        }
//
////        public String getChildrenToString() {
////
////            StringBuilder sb = new StringBuilder();
////            for (Node node : this.res) {
////                if (node.getWho() == this.root &&
////                        ((node.getRe() == Type.father) || (node.getRe() == Type.mother))) {
////                    sb.append(node.toString() + "\n");
////                }
////
////                if (node.getToWhom() == this.root &&
////                        ((node.getRe() == Type.son) || (node.getRe() == Type.daughter))) {
////
////                    sb.append(node.toString() + "\n");
////                }
////            }
////            return sb.toString();
////        }
////
////        public String getSiblingsToString() {
////
////            StringBuilder sb = new StringBuilder();
////            for (Node node : this.res) {
////                if ((node.getRe() == Type.brother) || (node.getRe() == Type.sister)) {
////                    sb.append(node.toString() + "\n");
////                }
////            }
////            return sb.toString();
////        }
//
//}
