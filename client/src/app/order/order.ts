import { Article } from "../article/article";

export class Order{
    id?: number;
    reference?: string;
    articles?: Article[];
    date?: Date;
}