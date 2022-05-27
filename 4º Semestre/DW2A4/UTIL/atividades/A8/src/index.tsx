import { StrictMode } from "react";
import { createRoot } from "react-dom/client";

import { App } from "./App";

const rootElement = document.getElementById("root");
if (!rootElement) throw new Error('O elemento "root" não pode ser encontrado');
const root = createRoot(rootElement);

root.render(
    <StrictMode>
        <App />
    </StrictMode>
);
/*
// Erro: ReactDOM.render method has been deprecated

import { render } from "react-dom";
import { App } from "./App.jsx";

render(<App />, document.getElementById('root'))*/