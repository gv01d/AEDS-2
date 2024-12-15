public class Tt {

    static public class ABB<T extends Comparable<T>> implements Comparable<ABB<T>> {
        ABNode<T> start;

        public class ABNode<E extends Comparable<T>> {
            ABNode<E> right, left;
            E value;

            ABNode(E val) {
                this.value = val;
                this.right = null;
                this.left = null;
            }
        }

        int insert(T val) {
            if (start == null) {
                start = new ABNode<T>(val);
                return 0;
            }
            return 1 + insert(new ABNode<T>(val), start);
        }

        int insert(ABNode<T> val, ABNode<T> nd) {
            if (val.value.compareTo(nd.value) >= 0) {
                if (nd.right == null) {
                    nd.right = val;
                    return 1;
                }
                return 1 + insert(val, nd.right);
            } else {
                if (nd.left == null) {
                    nd.left = val;
                    return 1;
                }
                return 1 + insert(val, nd.left);
            }
        }

        ABNode<T> findNd(T val) {
            ABNode<T> ret = start;
            return findNd(val, ret.left);
        }

        ABNode<T> findNd(T val, ABNode<T> nd) {
            int comp = nd.value.compareTo(val);
            if (comp == 0) {
                return nd;
            }
            if (comp > 0) {
                return findNd(val, nd.right);
            }
            return findNd(val, nd.left);
        }

        T remove(T val) {
            ABNode<T> nd = start;
            ABNode<T> og = start;
            T ret;
            while (nd != null) {
                int comp = nd.value.compareTo(val);
                if (comp == 0) {
                    if (nd == og.left) {
                        if (nd.left != null) {

                        }
                        og.left = nd.left;
                        if (nd.right != null) {
                            insert(nd.right, og);
                        }
                    }
                }
                og = nd;
                if (comp > 0) {
                    nd = nd.right;
                } else {
                    nd = nd.left;
                }
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
    }
}
