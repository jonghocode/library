import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './login';

function App() {
  return (
    <Router>
      <div>
        백엔드에서 가져온 데이터입니다 : {/* {hello} 이 부분에 실제 데이터 삽입 */}
      </div>
      <Routes>
        <Route path="/" element={<Login />} />
      </Routes>
    </Router>
  );
}

export default App;
