import ButtonDay from "./ButtonDay"

export default function Td_null({k}){
    const firstElements = Array(k).fill(0)
    .map((_, i) => <td key={i}><ButtonDay /></td>);
    return firstElements
} 