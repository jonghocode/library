import React, { useState,useEffect } from 'react';
import {seetList} from "./api";
function Main() {

    useEffect(() => {
        seetList();
    }, []);

    return (
        <>
            <div>
            </div>
        </>
    );

}

export default Main;