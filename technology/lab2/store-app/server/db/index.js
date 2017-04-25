/**
 * Created by Drapegnik on 26.03.17.
 */

import connectDb from './mongoose';
import initUsers from './users';
import { initProducts, initCatalogs } from './products';

const dropCollections = (mongoose) => {
  const collections = Object.keys(mongoose.connection.collections);
  const promises = [];

  collections.forEach((name) => {
    promises.push(new Promise((resolve, reject) => {
      const collection = mongoose.connection.collections[name];
      collection.drop((err) => {
        if (err && err.message !== 'ns not found') {
          reject(err);
        }
        resolve(name);
      });
    }));
  });

  return Promise.all(promises);
};

export { connectDb, initUsers, initProducts, initCatalogs, dropCollections };
