public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
  Map<Integer, List<Integer>> children = new HashMap<>();
  for (int i = 0; i < pid.size(); i++) {
    int parent = ppid.get(i), child = pid.get(i);
    children.putIfAbsent(parent, new ArrayList<>());
    children.get(parent).add(child);
  }
  List<Integer> res = new ArrayList<>();
  kill(children, kill, res);
  return res;
}

private void kill(Map<Integer, List<Integer>> children, int cur, List<Integer> res) {
	res.add(cur);
	List<Integer> childrenList = children.get(cur);
	if (childrenList == null) return;
	for (int child: childrenList) {
    kill(children, child, res);
  }
} 
