import { useState, useEffect } from "react";
import { getProducts, createProduct, updateProduct, deleteProduct } from "./api";
import ProductForm from "./ProductForm";
import ProductTable from "./ProductTable";
import { checkHealth } from './api';
function App() {  
   const [apiValue, setApiValue] = useState('');

  useEffect(() => {
    checkHealth().then((data) => {
      if (data && data.status) {
        // Zapisujemy wartość bezpośrednio z odpowiedzi API ("ok")
        setApiValue(data.status); 
      } else {
        setApiValue('error');
      }
    });
  }, []);

  return (
    <div>
      {/* 
        Wyświetlamy wartość z API. 
        Metoda .toUpperCase() zamieni "ok" pobrane z backendu na wymagane przez test "OK".
      */}
      <p>Status: {apiValue.toUpperCase()}</p>
    </div>
  );

}
export default App;
