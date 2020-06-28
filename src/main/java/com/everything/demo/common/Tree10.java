package com.everything.demo.common;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class Tree10<T> implements Serializable{
	private static final long serialVersionUID = -1796637658547025013L;
	private Tree10Node<T> root = new Tree10Node<>();

    public boolean addIndex(String index, T value) {
        if (!isNullOrNumeric(index)) {
            return false;
        }
        addNode(index, value, root);
        return true;
    }

    public T indexOf(String index) {
        if (!isNullOrNumeric(index)) {
            return null;
        }
        return valueOf(index, root, root.getValue());
    }

    private void addNode(String index, T value, Tree10Node<T> node) {
        if (StringUtils.isEmpty(index)) {
            node.setValue(value);
            return;
        }
        int i = index.charAt(0) - '0';
        Tree10Node<T> child = node.getNode(i);
        if (child == null) {
            child = new Tree10Node();
            node.setNode(i, child);
        }
        addNode(index.substring(1), value, child);
    }

    private T valueOf(String index, Tree10Node<T> node, T value) {
        if (StringUtils.isEmpty(index)) {
            return node.getValue();
        }
        int i = index.charAt(0) - '0';
        Tree10Node<T> child = node.getNode(i);
        if (child == null) {
            return value;
        }
        if (child.getValue() != null) {
            value = child.getValue();
        }
        return valueOf(index.substring(1), child, value);
    }

    private boolean isNullOrNumeric(String str) {
        if (str == null) {
            return true;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    private class Tree10Node<T> implements Serializable{
		private static final long serialVersionUID = 5148608606634712687L;

		private T value;

        private Tree10Node[] nodes = new Tree10Node[10];

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Tree10Node<T> getNode(int index) {
            return nodes[index];
        }

        public void setNode(int index, Tree10Node<T> node) {
            nodes[index] = node;
        }
    }
}
