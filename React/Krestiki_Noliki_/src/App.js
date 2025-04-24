import { useState } from "react";
export default function Board() {
  return <>
    <div className="board-row">
        <Square />
        <Square />
        <Square />
    </div>
    <div className="board-row">
        <Square />
        <Square />
        <Square />
    </div>
    <div className="board-row">
        <Square />
        <Square />
        <Square />
    </div>

  </>;
}
function Square(){
  const [value,setValue]=useState(null);
  function click(){
    setValue("X");
    console.log("Clicked "+value);
  }
  return <button className="square" onClick={click}>{value}</button>
}
