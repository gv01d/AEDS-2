public class Testing {

    public interface Node<T> {
    }

    static public class ABNode<E extends Comparable<E>> implements Node<E> {
        ABNode<E> right, left;
        E value;

        ABNode(E val) {
            this.value = val;
            this.right = null;
            this.left = null;
        }
    }

    static public class ABB<T extends Comparable<T>> implements Comparable<ABB<T>> {
        ABNode<T> start;

        int insert(T val) {
            if (start == null) {
                start.value = val;
            }
            return insert(new ABNode<>(val), start);
        }

        int insert(ABNode<T> in) {
            if (start == null) {
                start = in;
            }
            return insert(in, start);
        }

        protected int insert(ABNode<T> in, ABNode<T> nd) {
            if (in == null) {
                return -1;
            }
            if (nd == null) {
                return -1;
            }
            if (in.value.compareTo(nd.value) >= 0) {
                if (nd.right == null) {
                    nd.right = in;
                    return 1;
                }
                return 1 + insert(in, nd.right);
            } else {
                if (nd.left == null) {
                    nd.left = in;
                    return 1;
                }
                return 1 + insert(in, nd.left);
            }
        }

        int size() {
            if (start == null) {
                return 0;
            }
            return 1 + size(start);
        }

        int size(ABNode<T> nd) {
            if (nd == null) {
                return 0;
            }
            return 1 + size(nd.right) + size(nd.left);
        }

        public int compareTo(ABB<T> av2) {
            int ret = this.size() - av2.size();

            if (ret == 0) {
                return compare(this.start, av2.start);
            }

            return ret;
        }

        int compare(ABNode<T> nd1, ABNode<T> nd2) {
            int ret = nd1.value.compareTo(nd2.value);
            if (ret == 0) {
                return compare(nd1.right, nd2.left);
            }

            return ret;
        }

        Node<T> getNd(T val) {
            return getNd(val, start);
        }

        protected Node<T> getNd(T val, ABNode<T> nd) {
            int comp = val.compareTo(nd.value);
            if (comp > 0) {
                return getNd(val, nd.right);
            }
            if (comp < 0) {
                return getNd(val, nd.left);
            }
            return nd;
        }

        Node<T> getBiggest() {
            return getBiggest(start);
        }

        protected Node<T> getBiggest(ABNode<T> nd) {
            if (nd == null) {
                return null;
            }
            while (nd.right != null) {
                nd = nd.right;
            }
            return nd;

        }

        Node<T> getSmallest() {
            return getSmallest(start);
        }

        protected Node<T> getSmallest(ABNode<T> nd) {
            if (nd == null) {
                return null;
            }
            while (nd.left != null) {
                nd = nd.left;
            }
            return nd;

        }

        Node<T> delete(T val) {
            ABNode<T> nd = start;
            ABNode<T> ndParent = null;
            int comp = val.compareTo(nd.value);
            int lc = 0;
            while (comp != 0 && nd != null) {
                ndParent = nd;
                lc = comp;
                if (comp > 0) {
                    nd = nd.right;
                }
                if (comp < 0) {
                    nd = nd.left;
                }
                comp = val.compareTo(nd.value);
            }
            ABNode<T> prox = null;
            ABNode<T> other = null;
            if (nd.right != null) {
                prox = nd.right;
                other = nd.left;
            } else if (nd.left != null) {
                prox = nd.left;
            }
            if (ndParent != null) {
                if (lc < 0) {
                    ndParent.left = prox;
                    insert(other);
                } else {
                    ndParent.right = prox;
                    insert(other);
                }
                rebalance(ndParent);
            } else {
                start = prox;
                insert(other);
                rebalance(start);
            }
            return nd;
        }

        // rotations

        Node<T> rotateLeft(ABNode<T> nd) {
            ABNode<T> x = nd.right;
            ABNode<T> y = x.left;

            x.left = nd;
            nd.right = y;
            return x;
        }

        Node<T> rotateRight(ABNode<T> nd) {
            ABNode<T> x = nd.left;
            ABNode<T> y = x.right;

            x.right = nd;
            nd.left = y;
            return x;
        }

        int rebalance(ABNode<T> nd) {
            return 0;
        }

    }

    //

    // - - - - @ Red Black Tree @ - - - - //

    static public class RBNode<T extends Comparable<T>> extends ABNode<T> {
        RBNode<T> right, left;
        boolean col;

        RBNode(T val) {
            super(val);
            this.col = false;
        }
    }

    static public class RedBlackTree<T extends Comparable<T>> extends ABB<T> {

        RBNode<T> start;

        int insert(T val) {
            if (start == null) {
                start.value = val;
            }
            return insert(new RBNode<T>(val), start);
        }

        int insert(RBNode<T> in) {
            if (start == null) {
                start = in;
            }
            return insert(in, start);
        }

        @Override
        protected int insert(ABNode<T> in) {
            return insert(in, start);
        }
    }

    //

    // - - - - @ AVL Tree @ - - - - //

    static public class AVLNode<T extends Comparable<T>> extends ABNode<T> {
        // Override

        AVLNode<T> right, left;
        int height;

        AVLNode(T val) {
            super(val);
            this.height = 0;
        }

        // New

        AVLNode(T val, int height) {
            super(val);
            this.height = 0;
        }
    }

    static public class AVLtree<T extends Comparable<T>> extends ABB<T> {
        // Override

        AVLNode<T> start;

        int insert(T val) {
            if (start == null) {
                start.value = val;
            }
            int ret = insert(new RBNode<T>(val), start);
            rebalance(start);
            return ret;
        }

        int insert(AVLNode<T> in) {
            if (start == null) {
                start = in;
            }
            int ret = insert(in, start);
            rebalance(start);
            return ret;
        }

        protected int insert(ABNode<T> in, ABNode<T> nd) {
            if (in == null) {
                return -1;
            }
            if (nd == null) {
                return -1;
            }
            if (in.value.compareTo(nd.value) >= 0) {
                if (nd.right == null) {
                    nd.right = in;
                    rebalance(nd);
                    return 1;
                }
                rebalance(nd);
                return 1 + insert(in, nd.right);
            } else {
                if (nd.left == null) {
                    nd.left = in;
                    rebalance(nd);
                    return 1;
                }
                rebalance(nd);
                return 1 + insert(in, nd.left);
            }
        }

        @Override
        protected int insert(ABNode<T> in) {
            return insert(in, start);
        }

        // New

        int height(AVLNode<T> nd) {
            return nd == null ? -1 : nd.height;
        }

        void updateHeight(AVLNode<T> nd) {
            nd.height = 1 + Math.max(height(nd.left), height(nd.right));
        }

        int getBalance(AVLNode<T> nd) {
            return (nd == null) ? 0 : height(nd.right) - height(nd.left);
        }

        int recUpdateHeight() {
            return recUpdateHeight(start);
        }

        int recUpdateHeight(AVLNode<T> nd) {
            if (nd == null) {
                return -1;
            }
            nd.height = 1 + Math.max(recUpdateHeight(nd.left), recUpdateHeight(nd.right));
            return nd.height;
        }

        // rotation

        Node<T> rotateLeft(AVLNode<T> nd) {
            AVLNode<T> x = nd.right;
            AVLNode<T> y = x.left;
            x.left = nd;
            nd.right = y;
            updateHeight(nd);
            updateHeight(x);
            return x;
        }

        Node<T> rotateRight(AVLNode<T> nd) {
            AVLNode<T> x = nd.left;
            AVLNode<T> y = x.right;

            x.right = nd;
            nd.left = y;
            updateHeight(nd);
            updateHeight(x);
            return x;
        }

        void rebalance(AVLNode<T> nd) {
            updateHeight(nd);
            int balance = getBalance(nd);
            if (balance > 1) {
                if (height(nd.right.right) > height(nd.right.left)) {
                    rotateLeft(nd);
                } else {
                    rotateRight(nd.right);
                    rotateLeft(nd);
                }
            } else if (balance < -1) {
                if (height(nd.left.left) > height(nd.left.right))
                    rotateRight(nd);
                else {
                    rotateLeft(nd.left);
                    rotateRight(nd);
                }
            }
        }
    }
}
