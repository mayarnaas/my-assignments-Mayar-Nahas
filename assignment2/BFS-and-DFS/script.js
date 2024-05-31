// BFS implementation
function bfs(root) {
    const queue = [];
    queue.push(root);
  
    while (queue.length > 0) {
      const current = queue.shift();
      console.log(current); 
      const children = current.children;
      for (let i = 0; i < children.length; i++) {
        queue.push(children[i]);
      }
    }
  }
  
  // DFS implementation
  function dfs(root) {
    console.log(root); 
  
    const children = root.children;
    for (let i = 0; i < children.length; i++) {
      dfs(children[i]);
    }
  }
  
  
  const rootElement = document.documentElement; 
  bfs(rootElement); 
  dfs(rootElement); 