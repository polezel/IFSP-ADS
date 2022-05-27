import { RepositoryItem } from "./RepositoryItem";
import "../styles/repositories.scss";
import { useState, useEffect } from "react";

// https://api.github.com/users/mateusGPr/repos
/* const repository = {
    name: "Atividade",
    description: "Descrição da atividade",
    link: "https://mateusgpr.github.io/DW2A2-2022/atividades/A7/dist/index.html"
} */

interface Repository {
    id: number;
    name: string;
    description: string;
    html_url: string;
}

export function RepositoryList() {
    const [repositories, setRepositories] = useState<Repository[]>([])

    useEffect(() => {
        fetch('https://api.github.com/users/mateusGPr/repos')
            .then(res => res.json())
            .then(data => setRepositories(data))
    }, [])
    return (
        <section className="repository-list">
            <h1>Lista de repositórios</h1>
            <ul>
                {
                    repositories.map((repository) => {
                        return <RepositoryItem repository={repository} key={repository.id} />

                    })
                }
            </ul>
        </section>
    )
}